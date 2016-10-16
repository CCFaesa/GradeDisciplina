package br.com.dalcim.gradedisciplinas.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Wiliam on 16/10/2016.
 */

public abstract class BaseDAO extends SQLiteOpenHelper {
    private static final String BASE_NOME = "base";
    private static final int VERSAO = 1;

    protected static final String DISCIPLINA_TABELA = "DISCIPLINA";
    protected static final String DISCIPLINA_ID = "ID";
    protected static final String DISCIPLINA_NOME = "NOME";
    protected static final String DISCIPLINA_CARGA_HORARIA = "CARGA_HORARIA";
    protected static final String DISCIPLINA_HORARIOS = "HORARIOS";


    public BaseDAO(Context context) {
        super(context, BASE_NOME, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        StringBuilder stb = new StringBuilder();
        stb.append("CREATE TABLE IF NOT EXISTS " + DISCIPLINA_TABELA + " (");
        stb.append(DISCIPLINA_ID + " INTEGER PRIMARY KEY, ");
        stb.append(DISCIPLINA_NOME + " TEXT, ");
        stb.append(DISCIPLINA_CARGA_HORARIA + " INTEGER, ");
        stb.append(DISCIPLINA_HORARIOS + " INTEGER);");

        sqLiteDatabase.execSQL(stb.toString());

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
