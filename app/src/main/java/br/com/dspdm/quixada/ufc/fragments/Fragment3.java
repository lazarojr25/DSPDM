package br.com.dspdm.quixada.ufc.fragments;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.io.IOException;
import java.util.ArrayList;

import br.com.dspdm.quixada.ufc.R;


public class Fragment3 extends Fragment {

    GridView gridView;
    String[] number = new String[9];
    private MediaPlayer mediaPlayer;
    int[] imagens = {R.drawable.pad0,R.drawable.pad1,R.drawable.pad2,
                    R.drawable.pad3, R.drawable.pad4,R.drawable.pad5,
                    R.drawable.pad6, R.drawable.pad7,R.drawable.pad8};

    int[] sonoplastia = {R.raw.cavalo,R.raw.ebrincadeira,
                        R.raw.okok,R.raw.papelao,
                        R.raw.queissomeufilhocalma,R.raw.risada_nas_garras_da_patrulha,
                        R.raw.saveiro_pega_no_breu,R.raw.tome,
                        R.raw.uuuii};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        System.out.println("ON CREATE VIRE FRAGMENT 03");
        return inflater.inflate(R.layout.fragment_3, container, false);
    }

    @Override
    public void onPause() {
        super.onPause();
        mediaPlayer.stop();

    }

    @Override
    public void onResume() {
        super.onResume();
        System.out.println("ON RESUME ");
        Context context = this.getContext();
        gridView = (GridView) getView().findViewById(R.id.gridView);

        CustomAdapter customAdapter = new CustomAdapter(imagens,context);
        gridView.setAdapter(customAdapter);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        System.out.println("ON VIEW CREATED");
        Context context = this.getContext();
        gridView = (GridView) getView().findViewById(R.id.gridView);

        CustomAdapter customAdapter = new CustomAdapter(imagens,context);
        gridView.setAdapter(customAdapter);

       // mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int selectedImage = imagens[i];
                mediaPlayer = MediaPlayer.create( context,sonoplastia[i]);
                if(mediaPlayer.isPlaying())
                {
                    System.out.println("TA TOCANDO");
                    mediaPlayer.stop();
                    try {
                        mediaPlayer.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else
                {
                    System.out.println("NÃO TA TOCANDO");
                    mediaPlayer.start();
                }
            }
        });
        //gridView.setOnItemClickListener(new );
    }

    public void tocarAudio()
    {

    }

    public class CustomAdapter extends BaseAdapter
    {
        private int[] imagens;
        private Context context;
        private LayoutInflater layoutInflater;

        public CustomAdapter(int[] imagens,Context context)
        {
            this.imagens = imagens;
            this.context = context;
            this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return imagens.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup)
        {
            if(view == null)
            {
                view = layoutInflater.inflate(R.layout.grid_item, viewGroup, false);
            }
            ImageView imageView = view.findViewById(R.id.grid_image_1);

            imageView.setImageResource(imagens[i]);

            return view;
        }
    }
}