package com.hiy.hiyplayer;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.template.IProvider;


public abstract class BaseProvider implements IProvider {
    @Override
    public void init(Context context) {

    }

    abstract void getAppVersion();

}
