package br.com.dalcim.gradedisciplinas.model;

public class Disciplina {
    private long id;
    private String nome;
    private int cargaHoraria;
    private long horarios;

    public Disciplina() {
    }

    public Disciplina(String nome, long horarios) {
        this.nome = nome;
        this.horarios = horarios;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public long getHorarios() {
        return horarios;
    }

    public void setHorarios(long horarios) {
        this.horarios = horarios;
    }
}
