package br.com.dalcim.gradedisciplinas.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.dalcim.gradedisciplinas.R;
import br.com.dalcim.gradedisciplinas.adapter.EspacadorItemLista;
import br.com.dalcim.gradedisciplinas.adapter.GradeAdapter;
import br.com.dalcim.gradedisciplinas.dao.DisciplinaDAO;
import br.com.dalcim.gradedisciplinas.model.Disciplina;
import br.com.dalcim.gradedisciplinas.model.Grade;
import br.com.dalcim.gradedisciplinas.util.Combinadora;

public class GradesActivity extends AppCompatActivity {

    private RecyclerView recGrades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grades);

        iniciaComponentes();
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregaGrades();
    }

    private void iniciaComponentes() {
        recGrades = (RecyclerView) findViewById(R.id.lgra_rec_grades);
        recGrades.setLayoutManager(new LinearLayoutManager(this));
        recGrades.addItemDecoration(new EspacadorItemLista(this, R.dimen.card_margin));
    }

    private void carregaGrades() {
        new TaregaCarregaGrades(this, recGrades).execute();
    }

    class TaregaCarregaGrades extends AsyncTask<Void, Void, List<Grade>>{

        private Context context;
        private RecyclerView recGrades;
        private ProgressDialog dialog;

        public TaregaCarregaGrades(Context context, RecyclerView recGrades) {
            this.context = context;
            this.recGrades = recGrades;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = ProgressDialog.show(context, "", "Aguarde...", true);
        }

        @Override
        protected List<Grade> doInBackground(Void[] objects) {
            ArrayList<Grade> grades = new ArrayList<>();
            List<Disciplina> disciplinas = new DisciplinaDAO(context).buscaTodos();

            Grade novaGrade;
            for (Disciplina disciplina: disciplinas) {
                novaGrade = new Grade(disciplina);
                grades.add(novaGrade);
                Combinadora.adicionaSePossivel(grades, disciplina);
            }

            Collections.sort(grades, new Comparator<Grade>() {
                @Override
                public int compare(Grade grade1, Grade grade2){
                    return  (grade2.getCargaHoraria() + grade2.getDisciplinas().size()) - (grade1.getCargaHoraria() + grade1.getDisciplinas().size());
                }
            });

            return grades;
        }

        @Override
        protected void onPostExecute(List<Grade> grades) {
            recGrades.setAdapter(new GradeAdapter(context, grades));
            super.onPostExecute(grades);
            dialog.dismiss();
        }
    }
}
