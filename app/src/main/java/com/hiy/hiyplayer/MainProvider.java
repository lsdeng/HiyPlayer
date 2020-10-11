package com.hiy.hiyplayer;

import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;

@Route(path = "/provider/main", name = "mainProvider")
public class MainProvider extends BaseProvider {

    @Override
    public void getAppVersion() {
        Log.d("provder", "1");
    }
}
