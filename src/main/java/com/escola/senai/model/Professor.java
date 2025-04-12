package com.escola.senai.model;
import jakarta.persistence.*;


@Entity
public class Professor {

    @Id
    @GeneratedValues(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String nomeProfessor;
    private String disciplinaProfessor;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    public String getDisciplinaProfessor() {
        return disciplinaProfessor;
    }

    public void setDisciplinaProfessor(String disciplinaProfessor) {
        this.disciplinaProfessor = disciplinaProfessor;
    }
}
