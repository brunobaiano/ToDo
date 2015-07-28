package br.com.brunobaiano.todo.db;

import android.text.format.DateUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by aluno on 27/07/2015.
 */
public class Tarefa {
    private int codigo;
    private String titulo;
    private String descricao;
    private long horarioExecucao;

    public Tarefa() {
    }

    public Tarefa(String titulo, String descricao, long horarioExecucao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.horarioExecucao = horarioExecucao;
    }

        public int getCodigo() {
            return codigo;
        }

        public void setCodigo(int codigo) {
            this.codigo = codigo;
        }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public long getHorarioExecucao() {
        return horarioExecucao;
    }

    public void setHorarioExecucao(long horarioExecucao) {
        this.horarioExecucao = horarioExecucao;
    }

    @Override
    public String toString() {
        Date date=new Date(horarioExecucao);
        SimpleDateFormat df2 = new SimpleDateFormat("dd/MM/yy");
        String dateText = df2.format(date);
        return titulo + " HORARIO: " + dateText;
    }
}
