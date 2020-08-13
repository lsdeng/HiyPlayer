package com.hiy.hiyplayer.page;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.hiy.fiy.M.flutter.PageRouter;
import com.hiy.hiyplayer.R;

public class SplashActivity extends AppCompatActivity {
    static {
        System.loadLibrary("native-lib");
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application/Users/zhishui/tuya/TuyaBssFlutter/build/host/outputs/apk/debug/app-debug.apk.
     */
    public native String stringFromJNI(String origin);

    public native int plus(int a, int b);

    private TextView mPlusSumTv;
    private int sum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        findViewById(R.id.title_tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String resultTarget = stringFromJNI("I come from android world");
                Toast.makeText(SplashActivity.this, resultTarget, Toast.LENGTH_SHORT).show();
                PageRouter.openPageByUrl(SplashActivity.this, "sample://flutterPage", null);
            }
        });

        mPlusSumTv = findViewById(R.id.plus_tv);
        mPlusSumTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sum = plus(sum, 1);
                mPlusSumTv.setText(String.valueOf(sum));
            }
        });


    }
}
