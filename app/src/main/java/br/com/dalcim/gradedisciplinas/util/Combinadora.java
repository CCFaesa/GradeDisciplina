package br.com.dalcim.gradedisciplinas.util;

import java.util.ArrayList;

import br.com.dalcim.gradedisciplinas.model.Disciplina;

/**
 * Created by Wiliam on 16/10/2016.
 */

public abstract class Combinadora {
    public static void adicionaSePossivel(ArrayList<ArrayList<Disciplina>> pGrade, Disciplina pDisciplina){

        boolean possivel;
        ArrayList<Disciplina> novaGrade;
        ArrayList<ArrayList<Disciplina>> adicionarEssasGrades = new ArrayList<>();
        for (ArrayList<Disciplina> grade : pGrade) {
            possivel = true;
            for (Disciplina disciplina :grade) {
                if((disciplina.getHorarios() & pDisciplina.getHorarios()) != 0){
                    possivel = false;
                }
            }
            if(possivel){
                novaGrade = new ArrayList<>(grade);
                novaGrade.add(pDisciplina);
                adicionarEssasGrades.add(novaGrade);
            }
        }

        pGrade.addAll(adicionarEssasGrades);
    }
}
