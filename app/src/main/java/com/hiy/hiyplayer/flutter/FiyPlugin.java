package com.hiy.hiyplayer.flutter;

import android.content.Context;
import android.util.Log;

import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugin.common.StandardMessageCodec;

/**
 * @author zhishui <a href="mailto:liusd@tuya.com">Contact me.</a>
 * @since 2020/7/31
 */
public class FiyPlugin implements FlutterPlugin {

    MethodChannel channel;

    public static void registerWith(PluginRegistry.Registrar registrar) {
        Log.d("FLutterPlugun1", Log.getStackTraceString(new Throwable()));

        FiyPlugin plugin = new FiyPlugin();

        plugin.setupChannel(registrar.messenger(), registrar.context());
    }

    public MethodChannel getChannel() {
        return channel;
    }

    @Override
    public void onAttachedToEngine(FlutterPluginBinding binding) {
        Log.d("FLutterPlugun2", Log.getStackTraceString(new Throwable()));
        setupChannel(binding.getBinaryMessenger(), binding.getApplicationContext());
    }

    @Override
    public void onDetachedFromEngine(FlutterPluginBinding binding) {
       Log.d("FLutterPlugun3", Log.getStackTraceString(new Throwable()));
        if (channel != null) {
            channel.setMethodCallHandler(null);
            channel = null;
        }
    }

    public void setupChannel(BinaryMessenger messenger, Context context) {
        channel = new MethodChannel(messenger, "toast");
        FiyMethodCallHandler handler = new FiyMethodCallHandler(context);
        channel.setMethodCallHandler(handler);

        EventChannel eventChannel = new EventChannel(messenger, "event");
        FiyEventCallHandler handler1 = new FiyEventCallHandler(context);
        eventChannel.setStreamHandler(handler1);
    }
}
