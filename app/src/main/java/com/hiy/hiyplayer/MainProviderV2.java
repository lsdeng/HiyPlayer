package com.hiy.hiyplayer;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.template.IProvider;

@Route(path = "/app/provider", name = "mainProvider1")
public class MainProviderV2 implements IProvider {

    public void getAppVersion() {
        Log.d("provder", "1");
    }

    @Override
    public void init(Context context) {

    }
}
