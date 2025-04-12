package com.escola.senai.controller;

import com.escola.senai.model.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.AlunoService;

import java.util.List;


@Controller
    @RequestMapping("/alunos")
public class AlunoController {

        @Autowired
        private AlunoService _alunoServiceContext;

        //Listar todos
        @GetMapping
        public String listarAlunos(Model model) {
            List<Aluno> alunos = _alunoServiceContext.buscarTodosAlunos();
            model.addAttribute("alunos", alunos);
            return "alunos/listar";
        }

    // Formulário para novo aluno
    @GetMapping("/novo")
    public String novoAlunoForm(Model model) {
        model.addAttribute("aluno", new Aluno());
        return "alunos/form";
    }

    // Salvar novo aluno
    @PostMapping("/salvar")
    public String salvarAluno(@ModelAttribute Aluno aluno) {
        _alunoServiceContext.salvarAluno(aluno);
        return "redirect:/alunos";
    }

    // Formulário para editar aluno
    @GetMapping("/editar/{id}")
    public String editarAlunoForm(@PathVariable Long id, Model model) {
        Aluno aluno = _alunoServiceContext.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado com o ID: " + id));
        model.addAttribute("aluno", aluno);
        return "alunos/form";
    }

    // Atualizar aluno
    @PostMapping("/atualizar/{id}")
    public String alunoAtualizado(@PathVariable Long id, @ModelAttribute Aluno aluno) {
        _alunoServiceContext.salvarAluno(id, aluno);
        return "redirect:/alunos";
    }

    // Deletar aluno
    @GetMapping("/deletar/{id}")
    public String deletarAluno(@PathVariable Long id) {
        _alunoServiceContext.deletarAluno(id);
        return "redirect:/alunos";
    }

}

