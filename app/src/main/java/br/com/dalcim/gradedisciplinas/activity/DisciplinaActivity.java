package br.com.dalcim.gradedisciplinas.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ToggleButton;

import br.com.dalcim.gradedisciplinas.R;
import br.com.dalcim.gradedisciplinas.dao.DisciplinaDAO;
import br.com.dalcim.gradedisciplinas.model.Disciplina;
import br.com.dalcim.gradedisciplinas.model.Horario;

public class DisciplinaActivity extends AppCompatActivity {

    private Disciplina disciplina;

    private EditText edtNome;
    private EditText edtCargaHoraria;
    private ToggleButton tbtnSeg1;
    private ToggleButton tbtnSeg2;
    private ToggleButton tbtnTer1;
    private ToggleButton tbtnTer2;
    private ToggleButton tbtnQua1;
    private ToggleButton tbtnQua2;
    private ToggleButton tbtnQui1;
    private ToggleButton tbtnQui2;
    private ToggleButton tbtnSex1;
    private ToggleButton tbtnSex2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disciplina);
        iniciaComponentes();

        long disciplina_id = getIntent().getLongExtra("DISCIPLINA_ID", 0);
        if(disciplina_id > 0){
            disciplina = new DisciplinaDAO(this).buscaID(disciplina_id);
            edtNome.setText(disciplina.getNome());
            edtCargaHoraria.setText(String.valueOf(disciplina.getCargaHoraria()));

            long horarios = disciplina.getHorarios();

            tbtnSeg1.setChecked((horarios & Horario.SEGUNDA_PRIMEIRO) != 0);
            tbtnSeg2.setChecked((horarios & Horario.SEGUNDA_SEGUNDO) != 0);
            tbtnTer1.setChecked((horarios & Horario.TERCA_PRIMEIRO) != 0);
            tbtnTer2.setChecked((horarios & Horario.TERCA_SEGUNDO) != 0);
            tbtnQua1.setChecked((horarios & Horario.QUARTA_PRIMEIRO) != 0);
            tbtnQua2.setChecked((horarios & Horario.QUARTA_SEGUNDO) != 0);
            tbtnQui1.setChecked((horarios & Horario.QUINTA_PRIMEIRO) != 0);
            tbtnQui2.setChecked((horarios & Horario.QUINTA_SEGUNDO) != 0);
            tbtnSex1.setChecked((horarios & Horario.SEXTA_PRIMEIRO) != 0);
            tbtnSex2.setChecked((horarios & Horario.SEXTA_SEGUNDO) != 0);
        }else{
            disciplina = new Disciplina();
        }
    }

    private void iniciaComponentes() {
        edtNome = (EditText) findViewById(R.id.dis_edt_nome);
        edtCargaHoraria = (EditText) findViewById(R.id.dis_edt_carga_horaria);

        tbtnSeg1 = (ToggleButton) findViewById(R.id.dis_tbtn_seg1);
        tbtnSeg2 = (ToggleButton) findViewById(R.id.dis_tbtn_seg2);
        tbtnTer1 = (ToggleButton) findViewById(R.id.dis_tbtn_ter1);
        tbtnTer2 = (ToggleButton) findViewById(R.id.dis_tbtn_ter2);
        tbtnQua1 = (ToggleButton) findViewById(R.id.dis_tbtn_qua1);
        tbtnQua2 = (ToggleButton) findViewById(R.id.dis_tbtn_qua2);
        tbtnQui1 = (ToggleButton) findViewById(R.id.dis_tbtn_qui1);
        tbtnQui2 = (ToggleButton) findViewById(R.id.dis_tbtn_qui2);
        tbtnSex1 = (ToggleButton) findViewById(R.id.dis_tbtn_sex1);
        tbtnSex2 = (ToggleButton) findViewById(R.id.dis_tbtn_sex2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_disciplina, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mdis_men_salvar: salvar(); break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void salvar() {
        long horarios = 0;
        horarios |= tbtnSeg1.isChecked() ? Horario.SEGUNDA_PRIMEIRO : 0;
        horarios |= tbtnSeg2.isChecked() ? Horario.SEGUNDA_SEGUNDO : 0;
        horarios |= tbtnTer1.isChecked() ? Horario.TERCA_PRIMEIRO : 0;
        horarios |= tbtnTer2.isChecked() ? Horario.TERCA_SEGUNDO : 0;
        horarios |= tbtnQua1.isChecked() ? Horario.QUARTA_PRIMEIRO : 0;
        horarios |= tbtnQua2.isChecked() ? Horario.QUARTA_SEGUNDO : 0;
        horarios |= tbtnQui1.isChecked() ? Horario.QUINTA_PRIMEIRO : 0;
        horarios |= tbtnQui2.isChecked() ? Horario.QUINTA_SEGUNDO : 0;
        horarios |= tbtnSex1.isChecked() ? Horario.SEXTA_PRIMEIRO : 0;
        horarios |= tbtnSex2.isChecked() ? Horario.SEXTA_SEGUNDO : 0;

        disciplina.setHorarios(horarios);
        disciplina.setNome(edtNome.getText().toString());
        disciplina.setCargaHoraria(Integer.parseInt(edtCargaHoraria.getText().toString()));

        new DisciplinaDAO(this).salva(disciplina);
        finish();
    }
}
