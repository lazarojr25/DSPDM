package br.com.dspdm.quixada.ufc.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

import br.com.dspdm.quixada.ufc.R;

public class Fragment1 extends Fragment {

    private TextView textView,radioTextView;
    private ToggleButton toggleButton;
    private RadioButton radioButton;
    private RadioGroup radioGroup;
    private Button button,buttonEditText;
    private EditText editText;
    private AutoCompleteTextView autoCompleteET;

    private Spinner spinner;
    private static final String[] paths = {"item 1", "item 2", "item 3"};

    private static  final String[] COUNTRIES = new String[]
            {
                    "Afeganistão","Angola","Albania"
            };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        textView = getView().findViewById(R.id.txtViewExemplo);
        radioGroup = getView().findViewById(R.id.radioGroupExemplo);
        toggleButton = getView().findViewById(R.id.toggleButtonExemplo);
        editText = getView().findViewById(R.id.edtExemplo);
        button = getView().findViewById(R.id.botaoSelecao);
        radioTextView = getView().findViewById(R.id.textViewRadio);
        buttonEditText = getView().findViewById(R.id.buttonEditText);
        autoCompleteET = getView().findViewById(R.id.autoCompleteTextViewExemplo);
        spinner = (Spinner)getView().findViewById(R.id.spinner);
        editarTextView(view);
        toggleButtonExemplo(view);
        toggleRedioExemplo(view);

        ArrayAdapter<String>adapterSpinner = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item,paths);

        spinner.setAdapter(adapterSpinner);
        //spinner.setOnItemSelectedListener();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1,COUNTRIES);
        autoCompleteET.setAdapter(adapter);

        buttonEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(editText.getText().toString());
            }
        });

    }

    public void editarTextView(View view)
    {
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoDigitado = editText.getText().toString();
                textView.setText(textoDigitado);
            }
        });
    }

    public void toggleButtonExemplo(View view)
    {
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked)
                {
                    Toast.makeText(getActivity(), "ToggleButton ativado!!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getActivity(), "ToggleButton desativado!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void toggleRedioExemplo(View view)
    {

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int radioId = radioGroup.getCheckedRadioButtonId();

                System.out.println("RADIO ID: "+ radioId);
                radioButton = getView().findViewById(radioId);
                radioTextView.setText("Radio Button selecionado: "+radioButton.getText().toString());
            }
        });
    }
}