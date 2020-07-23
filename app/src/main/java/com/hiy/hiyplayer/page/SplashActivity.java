package com.hiy.hiyplayer.page;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.hiy.hiyplayer.R;

public class SplashActivity extends AppCompatActivity {
    static {
        System.loadLibrary("native-lib");
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application/Users/zhishui/tuya/TuyaBssFlutter/build/host/outputs/apk/debug/app-debug.apk.
     */
    public native String stringFromJNI();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Toast.makeText(this, stringFromJNI(), Toast.LENGTH_SHORT).show();

    }
}
