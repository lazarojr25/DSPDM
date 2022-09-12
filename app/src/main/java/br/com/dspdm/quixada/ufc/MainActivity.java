package br.com.dspdm.quixada.ufc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button botaoIniciar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoIniciar = (Button) findViewById(R.id.botaoIniciar);

        chamarSegundaTela();
    }

    public void chamarSegundaTela()
    {
        botaoIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(MainActivity.this, LanternaActivity.class);
                startActivity(in);
            }
        });
    }
}