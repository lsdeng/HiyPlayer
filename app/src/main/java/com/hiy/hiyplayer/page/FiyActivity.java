package com.hiy.hiyplayer.page;

import android.os.Bundle;
import android.os.Handler;

import com.hiy.hiyplayer.flutter.FiyPlugin;

import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.plugins.shim.ShimPluginRegistry;
import io.flutter.plugins.GeneratedPluginRegistrant;

public class FiyActivity extends FlutterActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FlutterEngine flutterEngine =  getFlutterEngine();
        if (flutterEngine != null) {
            FiyPlugin fiyPlugin = new FiyPlugin();
            flutterEngine.getPlugins().add(fiyPlugin);

             new Handler().postDelayed(new Runnable() {
                 @Override
                 public void run() {
                     fiyPlugin.getChannel().invokeMethod("test", "native => flutter");
                 }
             }, 1500);
//            FiyPlugin.registerWith(get);
        }




    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }


}
