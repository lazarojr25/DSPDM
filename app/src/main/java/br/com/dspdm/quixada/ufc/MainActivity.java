package br.com.dspdm.quixada.ufc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    TextView textoMain;
    ToggleButton toggleButton;
    ConstraintLayout main_view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main_view = (ConstraintLayout) findViewById(R.id.main_view);
        textoMain = (TextView)findViewById(R.id.textView);
        toggleButton = (ToggleButton) findViewById(R.id.toggleButton01);
        main_view.setBackgroundColor(Color.BLACK);
        textoMain.setTextColor(Color.WHITE);
        alteraCorFundo(main_view);
    }

    public void alteraCorFundo(ConstraintLayout main_view)
    {

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    textoMain.setText("Chave Ligada");
                    showMessage("Toggle buttom is on");
                    textoMain.setTextColor(Color.BLACK);
                    main_view.setBackgroundColor(Color.WHITE);

                } else {
                    // The toggle is disabled
                    showMessage("Toggle buttom is off");
                    textoMain.setText("Chave Desligada");
                    textoMain.setTextColor(Color.WHITE);
                    main_view.setBackgroundColor(Color.BLACK);
                }
            }
        });
    }

    private void showMessage(String message)
    {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}