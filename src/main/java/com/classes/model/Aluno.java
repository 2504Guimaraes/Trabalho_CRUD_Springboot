package com.classes.model;

public class Aluno {

    private int cd_aluno;
    private String nm_aluno;
    private String sg_sexoaluno;
    private int cd_curso;
    private double qt_notaaluno;
    private int qt_idade;

    public Aluno() {}
    

    // Setters:

    public void setNm(String nm_aluno) {
        this.nm_aluno = nm_aluno;
    }

    public void setSgSx(String sx_aluno) {
        this.sg_sexoaluno = sx_aluno;
    }

    public void setIdCurso(int cd_curso) {
        this.cd_curso = cd_curso;
    }

    public void setNota(double qt_notaaluno) {
        this.qt_notaaluno = qt_notaaluno;
    }

    public void setIdade(int idade) {
        this.qt_idade = idade;
    }

    // Getters:

    public int getId() {
        return this.cd_aluno;
    }

    public String getNm() {
        return this.nm_aluno;
    }

    public String getSgSx() {
        return this.sg_sexoaluno;
    }

    public int getIdCurso() {
        return this.cd_curso;
    }

    public double getNota() {
        return this.qt_notaaluno;
    }

    public int getIdade() {
        return this.qt_idade;
    }
}
