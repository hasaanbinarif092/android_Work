package com.example.bilalakbar.flashlight;

import android.app.Activity;
import android.content.Context;
import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.pm.PackageManager;
import android.hardware.Camera.Parameters;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;


import java.security.Policy;


public class MainActivity extends Activity {

    private boolean isLightOn = false;
    private Camera camera;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button1);
        Context context = this;
        PackageManager pm = context.getPackageManager();

        if (!pm.hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
            Log.e("err", "Device has no Camera");
            return;
        }

        camera = Camera.open();

        final Parameters p = camera.getParameters();

        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isLightOn) {
                    Log.i("info", "Torch is turn on ");
                    p.setFlashMode(Parameters.FLASH_MODE_OFF);
                    camera.setParameters(p);
                    camera.stopPreview();
                    isLightOn = false;

                } else {
                    Log.i("info", "Torch is turn on ");
                    p.setFlashMode(Parameters.FLASH_MODE_TORCH);
                    camera.setParameters(p);
                    camera.startPreview();
                    isLightOn = false;
                }

            }
        });
    }


    @Override
    protected void onStop()
    {
        super.onStop();

        if(camera!=null)
        {
            camera.release();
        }
    }
}
