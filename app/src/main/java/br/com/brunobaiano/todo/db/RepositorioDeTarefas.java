package br.com.brunobaiano.todo.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.brunobaiano.todo.ToDoApplication;

/**
 * Created by aluno on 27/07/2015.
 */
public class RepositorioDeTarefas {

    private SQLiteHelper dbHelper;

    private ToDoApplication application;
    public RepositorioDeTarefas(Context ctx) {

        dbHelper = new SQLiteHelper(ctx, "ToDo", 2);

        application = (ToDoApplication) ctx.getApplicationContext();
        application.db  = dbHelper.getWritableDatabase();

    }

    public void inserirTarefa (Tarefa tarefa) {

        ContentValues valores = new ContentValues();

        valores.put("titulo", tarefa.getTitulo());
        valores.put("descricao", tarefa.getDescricao());
        valores.put("horario", tarefa.getHorarioExecucao());

        application.db.insert("tarefas", null, valores);
    }

   /* public void find (Tarefa tarefa) {


        Cursor c =  application.db.query("tarefas", new String[] {"_id", "titulo"}, "titulo=?", new String[] {"nome consultado"}, null, null, null);

        if (c.getCount() > 0) {
            c.moveToFirst();

            Carro carro = new Carro();

            carro.id = c.getLong(0);
            carro.nome = c.getString(1);
        }
    }*/

    // Getting All Contacts
    public List<Tarefa> getTarefas() {
        List<Tarefa> tarefas = new ArrayList<Tarefa>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + "TAREFAS";
        Cursor cursor =  application.db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Tarefa tarefa = new Tarefa();
                tarefa.setCodigo(Integer.parseInt(cursor.getString(0)));
                tarefa.setTitulo(cursor.getString(1));
                tarefa.setDescricao(cursor.getString(2));
                tarefa.setHorarioExecucao(Long.parseLong(cursor.getString(3)));
                // Adding contact to list
                tarefas.add(tarefa);
            } while (cursor.moveToNext());
        }

        // return contact list
        return tarefas;
    }



}