package br.com.dspdm.quixada.ufc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import br.com.dspdm.quixada.ufc.Adapter.VPAdapter;
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

        vpAdapter.addFragment(new Fragment1() , "Exemplos gerais");
        vpAdapter.addFragment(new Fragment2() , "Lista de tarefas");
        vpAdapter.addFragment(new Fragment3() , "Launchpad");
        viewPager2.setAdapter(vpAdapter);

        new TabLayoutMediator(tabLayout, viewPager2,
                (tab, position) -> tab.setText(vpAdapter.getFragmentTitle(position))
        ).attach();
        tabLayout.getTabAt(1).select();
        getSupportActionBar().hide();
        //
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