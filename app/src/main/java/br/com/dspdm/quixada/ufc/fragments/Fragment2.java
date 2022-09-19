package br.com.dspdm.quixada.ufc.fragments;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import br.com.dspdm.quixada.ufc.DialogCloseListener;
import br.com.dspdm.quixada.ufc.R;
import br.com.dspdm.quixada.ufc.RecyclerItemTouchHelper;
import br.com.dspdm.quixada.ufc.armazenamento.BaseDadosTarefa;
import br.com.dspdm.quixada.ufc.model.Tarefa;
import br.com.dspdm.quixada.ufc.utils.AddTarefa;
import br.com.dspdm.quixada.ufc.Adapter.CustomAdapter;


public class Fragment2 extends Fragment implements DialogCloseListener {

    private RecyclerView tarefaRecycleView;
    private CustomAdapter customAdapter;
    private FloatingActionButton fab;

    private List<Tarefa> tarefaList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        System.out.println("ON CREATE VIRE FRAGMENT 02");

        return inflater.inflate(R.layout.fragment_2, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tarefaList = new ArrayList<>();

        tarefaRecycleView = getView().findViewById(R.id.recyclerViewTasks);
        tarefaRecycleView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        customAdapter = new CustomAdapter(this.getActivity());
        tarefaRecycleView.setAdapter(customAdapter);

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new RecyclerItemTouchHelper(customAdapter));
        itemTouchHelper.attachToRecyclerView(tarefaRecycleView);

        fab = getView().findViewById(R.id.fabTask);

        Tarefa tarefa = new Tarefa();
        tarefa.setNomeTarefa("Isso é uma tarefa teste");
        tarefa.setStatus(0);
        BaseDadosTarefa.getList().add(tarefa);
        BaseDadosTarefa.getList().add(tarefa);
        System.out.println("LISTA DA CLASSE "+BaseDadosTarefa.getList());
        customAdapter.setTasks(BaseDadosTarefa.getList());

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AddTarefa().show(getActivity().getSupportFragmentManager(), AddTarefa.newInstance().getTag());
            }
        });
    }

    @Override
    public void handleDialogClose(DialogInterface dialog)
    {
        customAdapter.setTasks(BaseDadosTarefa.getList());
        customAdapter.notifyDataSetChanged();
    }
}