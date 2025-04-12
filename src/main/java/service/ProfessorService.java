package service;

import com.escola.senai.model.Aluno;
import com.escola.senai.model.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AlunoRepository;
import repository.ProfessorRepository;

import java.util.List;
import java.util.Optional;

public class ProfessorService {


    @Autowired
    private ProfessorRepository professorRepository;

    //Cadastrar Professor
    public Professor salvarProfessor(Professor professor){
        return professorRepository.save(professor);
    }

    // Atualizar Professor
    public Professor atualizarProfessor(Long id, Professor professorAtualizado) {
        return professorRepository.findById(id)
                .map(professor -> {
                    professor.setNomeProfessor(professorAtualizado.getNomeProfessor());
                    professor.setDisciplinaProfessor(professorAtualizado.getDisciplinaProfessor());
                    return professorRepository.save(professor);
                })
                .orElseThrow(() -> new RuntimeException("Professor não encontrado com o ID: " + id));
    }

    //Bucar todos os Professores
    public List<Professor> buscarTodosProfessores(){
        return professorRepository.findAll();
    }

    //Buscar todos os Professores pelo id
    public Optional<Professor> buscarPorId(Long id) {
        return professorRepository.findById(id);
    }

    //Deletar Pofessor
    public void deletarProfessor(Long id) {
        professorRepository.deleteById(id);
    }
}
