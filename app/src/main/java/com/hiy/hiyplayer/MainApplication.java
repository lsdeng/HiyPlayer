package com.hiy.hiyplayer;

import android.app.Application;
import android.util.Log;

import com.hiy.hiyplayer.flutter.FlutterBoostDelegate;
import com.idlefish.flutterboost.interfaces.INativeRouter;
import com.tencent.mmkv.MMKVHandler;
import com.tencent.mmkv.MMKVLogLevel;
import com.tencent.mmkv.MMKVRecoverStrategic;

import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.view.FlutterMain;

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
