package br.com.dalcim.gradedisciplinas.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.List;

import br.com.dalcim.gradedisciplinas.R;
import br.com.dalcim.gradedisciplinas.adapter.DisciplinaAdapter;
import br.com.dalcim.gradedisciplinas.adapter.EspacadorItemLista;
import br.com.dalcim.gradedisciplinas.dao.DisciplinaDAO;
import br.com.dalcim.gradedisciplinas.model.Disciplina;

public class DisciplinasActivity extends AppCompatActivity {

    private RecyclerView recDisciplinas;
    private Button btnNovaDisciplina;

    private List<Disciplina> disciplinas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disciplinas);

        iniciaComponentes();
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregaDisciplinas();
    }

    private void carregaDisciplinas() {
        disciplinas = new DisciplinaDAO(this).buscaTodos();
        recDisciplinas.setAdapter(new DisciplinaAdapter(this, disciplinas, new DisciplinaAdapter.Listeners() {
            @Override
            public void onClick(long id) {
                Intent intent = new Intent(DisciplinasActivity.this, DisciplinaActivity.class);
                intent.putExtra("DISCIPLINA_ID", id);
                startActivity(intent);
            }

            @Override
            public void onLongClick(long id) {
                new DisciplinaDAO(DisciplinasActivity.this).deleta(id);
                carregaDisciplinas();
            }
        }));
    }

    private void iniciaComponentes() {
        recDisciplinas = (RecyclerView) findViewById(R.id.ldis_rec_disciplinas);
        recDisciplinas.setLayoutManager(new LinearLayoutManager(this));
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
