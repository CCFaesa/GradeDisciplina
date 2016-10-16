package br.com.dalcim.gradedisciplinas.model;

import java.util.ArrayList;

public class Grade {
    private ArrayList<Disciplina> disciplinas;
    private int cargaHoraria;
    private long horarios;

    public Grade() {
        disciplinas = new ArrayList<>();
    }

    public Grade(Disciplina disciplina) {
        this();
        disciplinas.add(disciplina);
        cargaHoraria = disciplina.getCargaHoraria();
        horarios = disciplina.getHorarios();
    }

    public ArrayList<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(ArrayList<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
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
