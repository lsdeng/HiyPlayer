package com.hiy.hiyplayer;

import android.app.Application;
import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;

//import com.hiy.fiy.M.flutter.FlutterBoostDelegate;

public class MainApplication extends Application {

    public static Context sContext;

    public static Context getAppContext() {
        return sContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
        initFlutter();
//        initMMKV();

        initArouter();

    }

    private void initFlutter() {
//        FlutterBoostDelegate.getInstance().init(this);
    }


    private void initArouter() {
        ARouter.openLog();     // Print log
        ARouter.openDebug();
        ARouter.init(this);
    }

}
