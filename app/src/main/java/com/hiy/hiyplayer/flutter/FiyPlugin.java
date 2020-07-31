package com.hiy.hiyplayer.flutter;

import android.content.Context;
import android.widget.Toast;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;

/**
 * @author zhishui <a href="mailto:liusd@tuya.com">Contact me.</a>
 * @since 2020/7/31
 */
public class FiyPlugin implements MethodChannel.MethodCallHandler {

    private Context context;

    public FiyPlugin(Context context) {
        this.context = context;
    }

    public static void registerWith(PluginRegistry.Registrar registrar) {
        MethodChannel channel = new MethodChannel(registrar.messenger(), "fiyMain");
        channel.setMethodCallHandler(new FiyPlugin(registrar.activity()));
    }

    @Override
    public void onMethodCall(MethodCall call, MethodChannel.Result result) {
        if (call.method.equals("toast")) {
            Toast.makeText(context, "test", Toast.LENGTH_SHORT).show();
            result.success("ok");
        }
    }
}
