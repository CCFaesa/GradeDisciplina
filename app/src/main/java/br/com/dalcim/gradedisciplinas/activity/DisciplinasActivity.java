package br.com.dalcim.gradedisciplinas.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import br.com.dalcim.gradedisciplinas.R;
import br.com.dalcim.gradedisciplinas.adapter.DisciplinaAdapter;
import br.com.dalcim.gradedisciplinas.adapter.EspacadorItemLista;
import br.com.dalcim.gradedisciplinas.model.Disciplina;
import br.com.dalcim.gradedisciplinas.model.Horario;

public class DisciplinasActivity extends AppCompatActivity {

    private RecyclerView recDisciplinas;
    private Button btnNovaDisciplina;

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

        recDisciplinas = (RecyclerView) findViewById(R.id.ldis_rec_disciplinas);
        recDisciplinas.setLayoutManager(new LinearLayoutManager(this));
        recDisciplinas.setAdapter(new DisciplinaAdapter(this, disciplinas));
        recDisciplinas.addItemDecoration(new EspacadorItemLista(this, R.dimen.card_margin));

        btnNovaDisciplina = (Button) findViewById(R.id.ldis_btn_nova_disciplina);
        btnNovaDisciplina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DisciplinasActivity.this, DisciplinaActivity.class));
            }
        });
    }
}
