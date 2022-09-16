package br.com.dspdm.quixada.ufc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import br.com.dspdm.quixada.ufc.databinding.ActivityMainBinding;
import br.com.dspdm.quixada.ufc.fragments.Fragment1;
import br.com.dspdm.quixada.ufc.fragments.Fragment2;
import br.com.dspdm.quixada.ufc.fragments.Fragment3;

public class MainActivity extends AppCompatActivity {


    //Button botaoIniciar;

    private TabLayout tabLayout;
    private ViewPager2 viewPager2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //botaoIniciar = (Button) findViewById(R.id.botaoIniciar);
        setContentView(R.layout.activity_main);
        tabLayout = findViewById(R.id.tableView);
        viewPager2 = findViewById(R.id.viewpager);


        VPAdapter vpAdapter = new VPAdapter(this );

        vpAdapter.addFragment(new Fragment1() , "Concluidos recentemente");
        vpAdapter.addFragment(new Fragment2() , "Lista de tarefas");
        vpAdapter.addFragment(new Fragment3() , "Launchpad");
        viewPager2.setAdapter(vpAdapter);

        new TabLayoutMediator(tabLayout, viewPager2,
                (tab, position) -> tab.setText(vpAdapter.getFragmentTitle(position))
        ).attach();

        //https://www.youtube.com/watch?v=ASQIvPwQffg&ab_channel=PenguinCoders
        //chamarSegundaTela();
    }

//    public void chamarSegundaTela()
//    {
//        botaoIniciar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent in = new Intent(MainActivity.this, LanternaActivity.class);
//                startActivity(in);
//            }
//        });
//    }
}