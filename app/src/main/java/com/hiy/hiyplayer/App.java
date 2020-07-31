package com.hiy.hiyplayer;

import android.app.Application;
import android.util.Log;

import com.tencent.mmkv.MMKVHandler;
import com.tencent.mmkv.MMKVLogLevel;
import com.tencent.mmkv.MMKVRecoverStrategic;

import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.view.FlutterMain;

public class App extends Application implements MMKVHandler {

    @Override
    public void onCreate() {
        super.onCreate();

        initFlutter();
//        initMMKV();
    }

    private void initFlutter() {
        FlutterMain.startInitialization(this);
    }

    // init mmkv lib
    private void initMMKV() {
//        String dir = getFilesDir().getAbsolutePath() + "mmkv";
//        String rootDir = MMKV.initialize(dir, new MMKV.LibLoader() {
//            @Override
//            public void (String s) {
////            Relinker
//            }
//        }, MMKVLogLevel.LevelInfo);
//
//        MMKV.registerHandler(this);
    }

    @Override
    public MMKVRecoverStrategic onMMKVCRCCheckFail(String s) {
        return MMKVRecoverStrategic.OnErrorRecover;
    }

    @Override
    public MMKVRecoverStrategic onMMKVFileLengthError(String s) {
        return MMKVRecoverStrategic.OnErrorRecover;
    }

    @Override
    public boolean wantLogRedirecting() {
        return true;
    }

    @Override
    public void mmkvLog(MMKVLogLevel mmkvLogLevel, String log, int i, String s1, String s2) {
//        String log = "<" + file + ":" + line + "::" + func + "> " + message;
        switch (mmkvLogLevel) {
            case LevelDebug:
                Log.d("redirect logging MMKV", log);
                break;
            case LevelNone:
            case LevelInfo:
                Log.i("redirect logging MMKV", log);
                break;
            case LevelWarning:
                Log.w("redirect logging MMKV", log);
                break;
            case LevelError:
                Log.e("redirect logging MMKV", log);
                break;
        }
    }
}
