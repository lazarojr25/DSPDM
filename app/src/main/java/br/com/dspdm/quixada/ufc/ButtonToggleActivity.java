package br.com.dspdm.quixada.ufc;

import android.content.pm.PackageManager;
import android.graphics.Camera;
import android.graphics.Color;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.hardware.camera2.CameraManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.security.Policy;

public class ButtonToggleActivity extends AppCompatActivity {

    private TextView statusLanterna;
    private ToggleButton toggleButton;
    private ConstraintLayout btntoggle_view;
    private CameraManager cameraManager;
    private Camera mCamera;
    private String getCameraID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_toggle);
        btntoggle_view = (ConstraintLayout) findViewById(R.id.activityToggleButtonId);
        statusLanterna = (TextView)findViewById(R.id.textView);
        toggleButton = findViewById(R.id.toggleButton01);
        btntoggle_view.setBackgroundColor(Color.BLACK);
        statusLanterna.setTextColor(Color.BLACK);
        alteraCorFundo(btntoggle_view);
        if(getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY))
        {
            if(getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH))
            {
                //podemos ligar o flash
            }else
            {
                Toast.makeText(ButtonToggleActivity.this, "Esse dispositivo não possui flash", Toast.LENGTH_SHORT).show();
            }
            //tem flash
        }else
        {
            Toast.makeText(ButtonToggleActivity.this, "Esse dispositivo não possui camera", Toast.LENGTH_SHORT).show();
        }
    }

    public void alteraCorFundo(ConstraintLayout main_view)
    {

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
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
                                cameraManager.setTorchMode("0",true  );
                            }
                        } catch (CameraAccessException e) {
                            e.printStackTrace();
                        }
                    }else
                    {
                        Toast.makeText(ButtonToggleActivity.this, "Esse dispositivo não possui flash", Toast.LENGTH_SHORT).show();
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
                            cameraManager.setTorchMode("cameraId",false);
                        }
                    } catch (CameraAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }


    private void showMessage(String message)
    {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}