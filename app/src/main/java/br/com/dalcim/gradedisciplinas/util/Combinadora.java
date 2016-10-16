package br.com.dalcim.gradedisciplinas.util;

import java.util.ArrayList;

import br.com.dalcim.gradedisciplinas.model.Disciplina;
import br.com.dalcim.gradedisciplinas.model.Grade;

/**
 * Created by Wiliam on 16/10/2016.
 */

public abstract class Combinadora {
    public static void adicionaSePossivel(ArrayList<Grade> pGrades, Disciplina pDisciplina){

        Grade novaGrade;
        ArrayList<Grade> adicionarGrades = new ArrayList<>();

        for (Grade grade : pGrades) {

            if((grade.getHorarios() & pDisciplina.getHorarios()) == 0){
                novaGrade = new Grade();
                novaGrade.setHorarios(grade.getHorarios() | pDisciplina.getHorarios());
                novaGrade.setCargaHoraria(grade.getCargaHoraria() + pDisciplina.getCargaHoraria());
                novaGrade.getDisciplinas().addAll(grade.getDisciplinas());
                novaGrade.getDisciplinas().add(pDisciplina);
                adicionarGrades.add(novaGrade);
            }
        }

        pGrades.addAll(adicionarGrades);
    }
}
