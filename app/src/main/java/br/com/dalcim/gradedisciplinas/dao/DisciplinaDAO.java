package br.com.dalcim.gradedisciplinas.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import br.com.dalcim.gradedisciplinas.model.Disciplina;

/**
 * Created by Wiliam on 16/10/2016.
 */

public class DisciplinaDAO extends BaseDAO {
    public DisciplinaDAO(Context context) {
        super(context);
    }

    public void insere(Disciplina disciplina){
        long id = getWritableDatabase().insert(DISCIPLINA_TABELA, null, getCV(disciplina));
        if(id > 0){
            disciplina.setId(0);
        }
    }

    public List<Disciplina> buscaTodos(){
        Cursor c = null;
        try{
            c = getReadableDatabase().rawQuery("SELECT * FROM " + DISCIPLINA_TABELA + ";", null);
        }catch (Exception e){
        }

        return cursorParaEntidade(c);
    }

    public Disciplina buscaID(long id){
        Cursor c = null;
        try{
            c = getReadableDatabase().rawQuery("SELECT * FROM " + DISCIPLINA_TABELA + " WHERE " + DISCIPLINA_ID + " = ?;", new String[]{String.valueOf(id)});
            if(c.moveToFirst()){
                Disciplina disciplina = new Disciplina();
                disciplina.setId(c.getLong(c.getColumnIndex(DISCIPLINA_ID)));
                disciplina.setCargaHoraria(c.getInt(c.getColumnIndex(DISCIPLINA_CARGA_HORARIA)));
                disciplina.setHorarios(c.getLong(c.getColumnIndex(DISCIPLINA_HORARIOS)));
                disciplina.setNome(c.getString(c.getColumnIndex(DISCIPLINA_NOME)));

                return disciplina;
            }
        }catch (Exception e){}

        return null;
    }

    public void altera(Disciplina disciplina){
        ContentValues cv = getCV(disciplina);
        cv.put(DISCIPLINA_ID, disciplina.getId());
        getWritableDatabase().update(DISCIPLINA_TABELA, cv, "id = ?", new String[]{String.valueOf(disciplina.getId())});
    }

    public void deleta(long id){
        getWritableDatabase().delete(DISCIPLINA_TABELA, "id = ?", new String[]{String.valueOf(id)});
    }

    public void salva(Disciplina disciplina){
        if(disciplina.getId() > 0){
            altera(disciplina);
        }else{
            insere(disciplina);
        }
    }

    private List<Disciplina> cursorParaEntidade(Cursor c) {

        List<Disciplina> disciplinas = new ArrayList<Disciplina>();

        Disciplina disciplina;
        while (c.moveToNext()) {
            disciplina = new Disciplina();
            disciplina.setId(c.getLong(c.getColumnIndex(DISCIPLINA_ID)));
            disciplina.setCargaHoraria(c.getInt(c.getColumnIndex(DISCIPLINA_CARGA_HORARIA)));
            disciplina.setHorarios(c.getLong(c.getColumnIndex(DISCIPLINA_HORARIOS)));
            disciplina.setNome(c.getString(c.getColumnIndex(DISCIPLINA_NOME)));

            disciplinas.add(disciplina);

        }

        return disciplinas;
    }

    private ContentValues getCV(Disciplina disciplina) {
        ContentValues cv = new ContentValues();
        cv.put(DISCIPLINA_NOME, disciplina.getNome());
        cv.put(DISCIPLINA_CARGA_HORARIA, disciplina.getCargaHoraria());
        cv.put(DISCIPLINA_HORARIOS, disciplina.getHorarios());

        return cv;
    }
}
