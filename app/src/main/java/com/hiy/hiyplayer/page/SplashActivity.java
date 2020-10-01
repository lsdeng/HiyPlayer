package com.hiy.hiyplayer.page;

import android.content.Intent;
import android.graphics.Camera;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.launcher.ARouter;
import com.hiy.fiy.M.flutter.PageRouter;
import com.hiy.hiyplayer.R;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class SplashActivity extends AppCompatActivity {
    static {
        System.loadLibrary("native-lib");
    }

    private TextView mPlusSumTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();


        findViewById(R.id.title_tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build("/app/main").navigation();
            }
        });

        mPlusSumTv = findViewById(R.id.plus_tv);
        mPlusSumTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                sum = plus(sum, 1);
//                mPlusSumTv.setText(String.valueOf(sum));

                Intent intent = new Intent(SplashActivity.this, CameraActivity.class);
                startActivity(intent);
            }
        });

    }
}
