package br.com.dspdm.quixada.ufc;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Camera;
import android.graphics.Color;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.os.Vibrator;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class LanternaActivity extends AppCompatActivity {

    private TextView statusLanterna;
    private ToggleButton toggleButton;
    private ImageButton imageButtonOnOffLantern;
    private ConstraintLayout btntoggle_view;
    private CameraManager cameraManager;
    private Camera mCamera;
    private String getCameraID;
    private Vibrator v;
    private Boolean onOffLanterna = false;

    private VideoView kabum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_toggle);
        btntoggle_view = (ConstraintLayout) findViewById(R.id.activityToggleButtonId);
        statusLanterna = (TextView)findViewById(R.id.textView);
        imageButtonOnOffLantern = (ImageButton)findViewById(R.id.imageButton_on_lantern);
        toggleButton = findViewById(R.id.toggleButton01);
        btntoggle_view.setBackgroundColor(Color.BLACK);
        statusLanterna.setTextColor(Color.BLACK);
        cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE); // instancio o gerenciador de camera
        v = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        kabum = (VideoView) findViewById(R.id.kabum);
        String path = "android.resource://br.com.dspdm.quixada.ufc/"+R.raw.kabum;
        Uri u = Uri.parse(path);
        kabum.setVideoURI(u);

        //alteraCorFundo(btntoggle_view);
        ligarLanterma(btntoggle_view);

    }

    public void ligarLanterma(ConstraintLayout main_view)
    {
        imageButtonOnOffLantern.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onOffLanterna = !onOffLanterna;
                if (onOffLanterna) { // liga o led e altera a cor de  fundo
                    // The toggle is enabled
                    statusLanterna.setText("Lanterna Ligada");
                    showMessage("Toggle buttom is on");
                    statusLanterna.setTextColor(Color.BLACK);
                    //main_view.setBackgroundColor(Color.WHITE);
                    if(getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH))
                    {
                        //dipositivo tem flash
                        try {
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                getCameraID = cameraManager.getCameraIdList()[0];
                                cameraManager.setTorchMode(getCameraID,true  );
                            }
                        } catch (CameraAccessException e) {
                            e.printStackTrace();
                        }
                        kabum.setVisibility(View.VISIBLE);
                        kabum.start();
                        if (Build.VERSION.SDK_INT >= 26) {
                            v.vibrate(VibrationEffect.createOneShot(1000,VibrationEffect.DEFAULT_AMPLITUDE));
                        }else
                        {
                            v.vibrate(200);
                        }

                        view.setVisibility(View.INVISIBLE);
                        imageButtonOnOffLantern = (ImageButton)findViewById(R.id.imageButton_off_lantern);
                        imageButtonOnOffLantern.setVisibility(View.VISIBLE);
                        ligarLanterma(btntoggle_view);

                    }else
                    {
                        Toast.makeText(LanternaActivity.this, "Esse dispositivo não possui flash", Toast.LENGTH_SHORT).show();
                    }


                } else {
                    // The toggle is disabled
                    showMessage("Toggle buttom is off");
                    statusLanterna.setText("Lanterna Desligada");
                    statusLanterna.setTextColor(Color.WHITE);
                    //main_view.setBackgroundColor(Color.BLACK);
                    try {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            String cameraId = cameraManager.getCameraIdList()[0];
                            cameraManager.setTorchMode(cameraId,false);
                        }
                    } catch (CameraAccessException e) {
                        e.printStackTrace();
                    }

                    view.setVisibility(View.INVISIBLE);
                    imageButtonOnOffLantern = (ImageButton)findViewById(R.id.imageButton_on_lantern);
                    imageButtonOnOffLantern.setVisibility(View.VISIBLE);
                    ligarLanterma(btntoggle_view);
                    kabum.stopPlayback();
                    kabum.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    /*
    liga lanterna usando toggleButton
    public void alteraCorFundo(ConstraintLayout main_view)
    {

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {//checa se o togglebutton é alterado
                if (isChecked) { // liga o led e altera a cor de  fundo
                    // The toggle is enabled
                    statusLanterna.setText("Lanterna Ligada");
                    showMessage("Toggle buttom is on");
                    statusLanterna.setTextColor(Color.BLACK);
                    main_view.setBackgroundColor(Color.WHITE);
                    if(getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH))
                    {
                        //dipositivo tem flash
                        try {

                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                getCameraID = cameraManager.getCameraIdList()[0];
                                cameraManager.setTorchMode(getCameraID,true  );
                            }
                        } catch (CameraAccessException e) {
                            e.printStackTrace();
                        }
                    }else
                    {
                        Toast.makeText(LanternaActivity.this, "Esse dispositivo não possui flash", Toast.LENGTH_SHORT).show();
                        buttonView.setChecked(false);
                    }


                } else {
                    // The toggle is disabled
                    showMessage("Toggle buttom is off");
                    statusLanterna.setText("Lanterna Desligada");
                    statusLanterna.setTextColor(Color.WHITE);
                    main_view.setBackgroundColor(Color.BLACK);
                    try {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            String cameraId = cameraManager.getCameraIdList()[0];
                            cameraManager.setTorchMode(cameraId,false);
                        }
                    } catch (CameraAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }*/


    private void showMessage(String message)
    {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}