package br.com.dspdm.quixada.ufc.utils;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import br.com.dspdm.quixada.ufc.DialogCloseListener;
import br.com.dspdm.quixada.ufc.R;
import br.com.dspdm.quixada.ufc.armazenamento.BaseDadosTarefa;
import br.com.dspdm.quixada.ufc.model.Tarefa;

public class AddTarefa  extends BottomSheetDialogFragment
{
    private EditText newTaskText;
    private Button newTaskSaveButton;

    public static AddTarefa newInstance()
    {
        return  new AddTarefa();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NORMAL, R.style.DialogStyle);
    }

    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.adicionar_task,container,false);
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        newTaskText = getView().findViewById(R.id.novaTaskText);
        newTaskSaveButton = getView().findViewById(R.id.novaTarefaButton);

        boolean isUpdate = false;
        final Bundle bundle = getArguments();
        if(bundle != null){
            isUpdate = true;
            String task = bundle.getString("task");
            newTaskText.setText(task);
            if(task.length()>0)
            {
                newTaskSaveButton.setTextColor(ContextCompat.getColor(getContext(), R.color.black));
            }
            newTaskText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if(charSequence.toString().equals(""))
                    {
                        newTaskSaveButton.setEnabled(false);
                        newTaskSaveButton.setTextColor(Color.GRAY);
                    }
                    else
                    {
                        newTaskSaveButton.setEnabled(true);
                        newTaskSaveButton.setTextColor(ContextCompat.getColor(getContext(), R.color.black));
                    }
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });

            boolean finalIsUpdate = isUpdate;
            newTaskSaveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String text = newTaskText.getText().toString();
                    if(finalIsUpdate)
                    {
                        BaseDadosTarefa.getList().get(bundle.getInt("id")).setNomeTarefa(text);

                    }
                    else
                    {
                        Tarefa task = new Tarefa();
                        task.setNomeTarefa(text);
                        task.setStatus(0);
                    }
                    dismiss();
                }
            });
        }
    }

    @Override
    public void onDismiss(@NonNull DialogInterface dialog) {
        Activity activity = getActivity();
        if(activity instanceof DialogCloseListener)
        {
            ((DialogCloseListener)activity).handleDialogClose(dialog);
        }
    }
}
