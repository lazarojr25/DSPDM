package br.com.dspdm.quixada.ufc.armazenamento;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import br.com.dspdm.quixada.ufc.model.Tarefa;

public class BaseDadosTarefa
{
    public static List<Tarefa> tarefaList = new ArrayList<Tarefa>();


    public static void addTarefa(Tarefa tarefa)
    {
        tarefaList.add(tarefa);
    }

    public static void removeTarefa(int position)
    {
        tarefaList.remove(position);
    }

    public static List<Tarefa> getList()
    {
        return tarefaList;
    }
}
