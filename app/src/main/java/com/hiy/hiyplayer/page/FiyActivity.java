package com.hiy.hiyplayer.page;

import android.os.Bundle;

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
            FiyPlugin.registerWith();
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
