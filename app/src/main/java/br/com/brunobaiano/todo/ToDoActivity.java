package br.com.brunobaiano.todo;

import android.content.Intent;
import android.os.SystemClock;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import br.com.brunobaiano.todo.db.RepositorioDeTarefas;
import br.com.brunobaiano.todo.db.Tarefa;


public class ToDoActivity extends AppCompatActivity {
    RepositorioDeTarefas repositorio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do);
        repositorio = new RepositorioDeTarefas(this);

        exibirTarefas();
    }

    private void exibirTarefas() {
        ListView lista = (ListView) findViewById(R.id.listView);
        lista.setAdapter(new ArrayAdapter<Tarefa>(this,R.layout.simple_list_item_1, repositorio.getTarefas()));
    }

    public void adicionarTarefa(View view)
    {
      //  Tarefa tarefa = new Tarefa("tarefa " + SystemClock.elapsedRealtime(),"descricao 1", SystemClock.elapsedRealtime());
       // repositorio.inserirTarefa(tarefa);
       // Toast.makeText(this,"teste",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,TarefaActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_to_do, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
