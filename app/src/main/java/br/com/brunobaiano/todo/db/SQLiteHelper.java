package br.com.brunobaiano.todo.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by aluno on 27/07/2015.
 */
public class SQLiteHelper extends SQLiteOpenHelper {
    private List<String> scriptSQLCreate;
    private String scriptSQLDelete;

    public SQLiteHelper(Context context, String nomeBanco, int versaoBanco) {
        super(context, nomeBanco, null, versaoBanco);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       buscarScriptsCriacaoBanco();

        for (String sql : scriptSQLCreate)
            db.execSQL(sql);

    }

    private void buscarScriptsCriacaoBanco() {
        scriptSQLCreate = new ArrayList<String>();
        scriptSQLCreate.add("create table tarefas (_id integer primary key autoincrement, titulo text not null, descricao text null, horario long not null );");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versaoAntiga, int novaVersao) {
        scriptSQLDelete = "DROP TABLE tarefas";
        db.execSQL(scriptSQLDelete);
        onCreate(db);
    }
}
