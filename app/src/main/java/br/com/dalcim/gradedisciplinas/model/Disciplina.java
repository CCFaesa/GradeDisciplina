package br.com.dalcim.gradedisciplinas.model;

public class Disciplina {
    private String nome;
    private String cargaHoraria;
    private long horarios;

    public Disciplina() {
    }

    public Disciplina(String nome, long horarios) {
        this.nome = nome;
        this.horarios = horarios;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public long getHorarios() {
        return horarios;
    }

    public void setHorarios(long horarios) {
        this.horarios = horarios;
    }
}
