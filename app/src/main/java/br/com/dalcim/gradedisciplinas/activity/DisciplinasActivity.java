package br.com.dalcim.gradedisciplinas.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import br.com.dalcim.gradedisciplinas.R;
import br.com.dalcim.gradedisciplinas.adapter.DisciplinaAdapter;
import br.com.dalcim.gradedisciplinas.adapter.EspacadorItemLista;
import br.com.dalcim.gradedisciplinas.model.Disciplina;
import br.com.dalcim.gradedisciplinas.model.Horario;

public class DisciplinasActivity extends AppCompatActivity {

    private RecyclerView recDisciplinas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disciplinas);

        iniciaComponentes();
    }

    private void iniciaComponentes() {
        ArrayList<Disciplina> disciplinas = new ArrayList<>();
        disciplinas.add(new Disciplina("INTRODUCAO A COMPUTACAO", Horario.SEGUNDA_PRIMEIRO | Horario.QUARTA_PRIMEIRO));
        disciplinas.add(new Disciplina("ALGORITMO II", Horario.SEGUNDA_PRIMEIRO | Horario.QUARTA_SEGUNDO));
        disciplinas.add(new Disciplina("LINGUAGEM DE PROGRAMACAO I", Horario.TERCA_PRIMEIRO | Horario.QUINTA_PRIMEIRO));
        disciplinas.add(new Disciplina("CALCULA III", Horario.QUARTA_SEGUNDO | Horario.SEXTA_PRIMEIRO));
        disciplinas.add(new Disciplina("MATEMATICA DISCRETA", Horario.SEGUNDA_SEGUNDO | Horario.TERCA_SEGUNDO));
        disciplinas.add(new Disciplina("PESQUISA APLICADA", Horario.TERCA_SEGUNDO | Horario.QUARTA_SEGUNDO));
        disciplinas.add(new Disciplina("ENGENHARIA DE SOFTWARE", Horario.QUARTA_SEGUNDO | Horario.QUINTA_PRIMEIRO));
        disciplinas.add(new Disciplina("PESQUISA E ORDENAÇÃO", Horario.SEGUNDA_PRIMEIRO | Horario.QUARTA_PRIMEIRO));
        disciplinas.add(new Disciplina("BANCO DE DADOS", Horario.QUINTA_PRIMEIRO | Horario.SEXTA_PRIMEIRO));
        disciplinas.add(new Disciplina("ARQUITETURA DE COMPUTADORES", Horario.QUINTA_PRIMEIRO | Horario.SEXTA_SEGUNDO));
        disciplinas.add(new Disciplina("DIREITO DA COMPUTACAO", Horario.TERCA_PRIMEIRO | Horario.SEXTA_PRIMEIRO));

        recDisciplinas = (RecyclerView) findViewById(R.id.ldis_rec_disciplinas);
        recDisciplinas.setLayoutManager(new LinearLayoutManager(this));
        recDisciplinas.setAdapter(new DisciplinaAdapter(this, disciplinas));
        recDisciplinas.addItemDecoration(new EspacadorItemLista(this, R.dimen.card_margin));
    }
}
