package com.hiy.hiyplayer;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;

import io.flutter.app.FlutterActivityDelegate;
import io.flutter.app.FlutterActivityEvents;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugins.GeneratedPluginRegistrant;
import io.flutter.view.FlutterNativeView;
import io.flutter.view.FlutterView;

public class HiyFlutterActivity extends Activity implements FlutterView.Provider, PluginRegistry, FlutterActivityDelegate.ViewFactory {

    private final FlutterActivityDelegate delegate = new FlutterActivityDelegate(this, this);

    // These aliases ensure that the methods we forward to the delegate adhere
    // to relevant interfaces versus just existing in FlutterActivityDelegate.
    private final FlutterActivityEvents eventDelegate = delegate;
    private final FlutterView.Provider viewProvider = delegate;
    private final PluginRegistry pluginRegistry = delegate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        eventDelegate.onCreate(savedInstanceState);
    }




    @Override
    public FlutterView createFlutterView(Context context) {
        return viewProvider.getFlutterView();
    }

    @Override
    public FlutterNativeView createFlutterNativeView() {
        return null;
    }

    @Override
    public boolean retainFlutterNativeView() {
        return false;
    }

    @Override
    public Registrar registrarFor(String pluginKey) {
        return pluginRegistry.registrarFor(pluginKey);
    }

    @Override
    public boolean hasPlugin(String pluginKey) {
        return pluginRegistry.hasPlugin(pluginKey);
//        return false;
    }

    @Override
    public <T> T valuePublishedByPlugin(String pluginKey) {
        return pluginRegistry.valuePublishedByPlugin(pluginKey);

    }

    @Override
    public FlutterView getFlutterView() {
        return null;
    }


    @Override
    protected void onStart() {
        super.onStart();
        eventDelegate.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        eventDelegate.onResume();
    }

    @Override
    protected void onDestroy() {
        eventDelegate.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        if (!eventDelegate.onBackPressed()) {
            super.onBackPressed();
        }
    }

    @Override
    protected void onStop() {
        eventDelegate.onStop();
        super.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
        eventDelegate.onPause();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        eventDelegate.onPostResume();
    }
}
