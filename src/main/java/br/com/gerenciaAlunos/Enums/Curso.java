package br.com.gerenciaAlunos.Enums;

public enum Curso {

    ADMINISTRACAO("Administração"),
    INFORMATICA("Informatica"),
    PROGRAMACAO("Programação"),
    ENFERMAGEM("Enfermagem");

    private String curso;

    private Curso(String curso){
        this.curso = curso;
    }
}
