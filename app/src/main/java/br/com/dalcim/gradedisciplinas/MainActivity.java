package br.com.dalcim.gradedisciplinas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;

import br.com.dalcim.gradedisciplinas.model.Disciplina;
import br.com.dalcim.gradedisciplinas.model.Horario;
import br.com.dalcim.gradedisciplinas.util.Combinadora;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "DEBUGRE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Disciplina> disciplinas = new ArrayList<>();
        disciplinas.add(new Disciplina("INTRODUCAO A COMPUTACAO", Horario.SEGUNDA_PRIMEIRO + Horario.QUARTA_PRIMEIRO));
        disciplinas.add(new Disciplina("ALGORITMO II", Horario.SEGUNDA_PRIMEIRO + Horario.QUARTA_SEGUNDO));
        disciplinas.add(new Disciplina("LINGUAGEM DE PROGRAMACAO I", Horario.TERCA_PRIMEIRO + Horario.QUINTA_PRIMEIRO));
        disciplinas.add(new Disciplina("CALCULA III", Horario.QUARTA_SEGUNDO + Horario.SEXTA_PRIMEIRO));
        disciplinas.add(new Disciplina("MATEMATICA DISCRETA", Horario.SEGUNDA_SEGUNDO + Horario.TERCA_SEGUNDO));
        disciplinas.add(new Disciplina("PESQUISA APLICADA", Horario.TERCA_SEGUNDO + Horario.QUARTA_SEGUNDO));
        disciplinas.add(new Disciplina("ENGENHARIA DE SOFTWARE", Horario.QUARTA_SEGUNDO + Horario.QUINTA_PRIMEIRO));
        disciplinas.add(new Disciplina("PESQUISA E ORDENAÇÃO", Horario.SEGUNDA_PRIMEIRO + Horario.QUARTA_PRIMEIRO));
        disciplinas.add(new Disciplina("BANCO DE DADOS", Horario.QUINTA_PRIMEIRO + Horario.SEXTA_PRIMEIRO));
        disciplinas.add(new Disciplina("ARQUITETURA DE COMPUTADORES", Horario.QUINTA_PRIMEIRO + Horario.SEXTA_SEGUNDO));
        disciplinas.add(new Disciplina("DIREITO DA COMPUTACAO", Horario.TERCA_PRIMEIRO + Horario.SEXTA_PRIMEIRO));
        

        ArrayList<ArrayList<Disciplina>> grades = new ArrayList<>();
        ArrayList<Disciplina> novaGrade;

        for (Disciplina disciplina : disciplinas) {
            novaGrade = new ArrayList<>();
            novaGrade.add(disciplina);
            grades.add(novaGrade);
            Combinadora.adicionaSePossivel(grades, disciplina);
        }

        for (ArrayList<Disciplina> grade : grades) {
            String a = "";
            for (Disciplina d : grade) {
                a += d.getNome() + " ";
            }

            Log.i(TAG, "onCreate: " + a);
        }
    }
}
