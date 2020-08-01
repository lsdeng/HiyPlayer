package com.hiy.hiyplayer.flutter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

/**
 * @author zhishui <a href="mailto:liusd@tuya.com">Contact me.</a>
 * @since 2020/7/31
 */
public class FiyMethodCallHandler implements MethodChannel.MethodCallHandler {

    private Context context;

    public FiyMethodCallHandler(Context context) {
        this.context = context;
    }


    @Override
    public void onMethodCall(MethodCall call, MethodChannel.Result result) {
        Log.d("FLutterPlugun3", Log.getStackTraceString(new Throwable()));
        if (call.method.equals("toast")) {
            String message = call.argument("msg");
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
            result.success("ok");
        }
    }
}
