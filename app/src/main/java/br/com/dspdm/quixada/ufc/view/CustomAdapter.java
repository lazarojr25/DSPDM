package br.com.dspdm.quixada.ufc.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.dspdm.quixada.ufc.R;
import br.com.dspdm.quixada.ufc.model.Tarefa;
import br.com.dspdm.quixada.ufc.utils.AddTarefa;

public class CustomAdapter extends  RecyclerView.Adapter<CustomAdapter.ViewHolder>
{
    private List<Tarefa> localDataSet;
    private FragmentActivity activit;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */

    public void deleteItem(int position)
    {
        //Tarefa item = localDataSet.get(position);
        localDataSet.remove(position);
        notifyItemRemoved(position);
    }


    public void editItem(int position)
    {
        Tarefa item = localDataSet.get(position);
        Bundle bundle = new Bundle();
        bundle.putInt("id",item.getId());
        bundle.putString("nomeTarefa",item.getNomeTarefa());
        AddTarefa fragment = new AddTarefa();
        fragment.setArguments(bundle);
        fragment.show(activit.getSupportFragmentManager(),AddTarefa.newInstance().getTag());
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final CheckBox taskCheckBox;


        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            taskCheckBox = view.findViewById(R.id.tarefaCheckBox);


        }

        public CheckBox getCheckBox() {
            return taskCheckBox;
        }


    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView.
     */
    public CustomAdapter( ArrayList<Tarefa> dataSet) {
        localDataSet = dataSet;
    }
    public CustomAdapter(FragmentActivity mainActivity) {

        this.activit = mainActivity;
    }

    public void setTasks(List<Tarefa> toDoList)
    {
        this.localDataSet = toDoList;
        notifyDataSetChanged();
    }
    // Create new views (invoked by the layout manager)
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.activity_activity_item_tarefa, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        Tarefa item = localDataSet.get(position);
        viewHolder.taskCheckBox.setText(item.getNomeTarefa());
        viewHolder.taskCheckBox.setChecked(Boolean.parseBoolean(item.gettSatusTarefa()));
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        //viewHolder.getTextView().setText( localDataSet.get( position ).toString() );

//        viewHolder.getCheckBox().setOnClickListener(new View.OnClickListener() {
//             @Override
//            public void onClick(View view) {
//                localDataSet.remove( viewHolder.getAdapterPosition() );
//                CustomAdapter.this.notifyDataSetChanged();
//            }
//        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.size();
    }



}
