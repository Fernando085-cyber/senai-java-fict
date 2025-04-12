package service;
import com.escola.senai.model.Aluno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AlunoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    //Cadastrar aluno
    public Aluno salvarAluno(Aluno aluno){
        return alunoRepository.save(aluno);
    }

    //Atualizar aluno
    public Aluno salvarAluno(Long id, Aluno alunoAtualizado){
        return alunoRepository.findById(id)
                .map(aluno -> {
                    aluno.setNomeAluno(alunoAtualizado.getNomeAluno());
                    aluno.setIdadeAluno(alunoAtualizado.getIdadeAluno());
                    aluno.setMatriculaAluno(alunoAtualizado.getMatriculaAluno());
                    return alunoRepository.save(aluno);
                })
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado com o ID: " + id));
    }

    //Bucar todos os alunos
    public List<Aluno> buscarTodosAlunos(){
        return alunoRepository.findAll();
    }

    //Buscar todos os alunos pelo id
    public Optional<Aluno> buscarPorId(Long id) {
        return alunoRepository.findById(id);
    }

    //Deletar Aluno
    public void deletarAluno(Long id) {
        alunoRepository.deleteById(id);
    }
}

