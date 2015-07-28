package br.com.brunobaiano.todo;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by aluno on 27/07/2015.
 */
public class ToDoApplication extends Application {
    private static ToDoApplication singleton;

    public SQLiteDatabase db;

    public ToDoApplication getInstance(){
        return singleton;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        singleton = this;
    }
}
