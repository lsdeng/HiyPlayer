package com.hiy.hiyplayer.page;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.hiy.hiyplayer.R;

@Route(path = "/app/main")
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        SimpleExoPlayer player = new SimpleExoPlayer.Builder(this).build();

//        playerView
    }
}
