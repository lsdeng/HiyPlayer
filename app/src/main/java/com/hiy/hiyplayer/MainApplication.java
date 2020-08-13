package com.hiy.hiyplayer;

import android.app.Application;

import com.hiy.fiy.M.flutter.FlutterBoostDelegate;

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        initFlutter();
//        initMMKV();
    }

    private void initFlutter() {
        FlutterBoostDelegate.getInstance().init(this);
    }

}
