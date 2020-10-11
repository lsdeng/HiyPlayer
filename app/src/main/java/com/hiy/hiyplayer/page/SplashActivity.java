package com.hiy.hiyplayer.page;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
//import com.hiy.fiy.M.flutter.PageRouter;
import com.hiy.base.BaseActivity;
import com.hiy.hiyplayer.MainProvider;
import com.hiy.hiyplayer.R;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

//        Intent i = new Intent(this, MainActivity.class);
////        startActivity(i);

        findViewById(R.id.root).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build("/app/main").navigation();
            }
        });

        ARouter.getInstance().build("/app/main").navigation();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
