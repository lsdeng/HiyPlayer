package com.hiy.hiyplayer.flutter;

import android.content.Context;
import android.util.Log;

import io.flutter.plugin.common.EventChannel;

/**
 * @author zhishui <a href="mailto:liusd@tuya.com">Contact me.</a>
 * @since 2020/7/31
 */
public class FiyEventCallHandler implements EventChannel.StreamHandler {

    private Context context;

    public FiyEventCallHandler(Context context) {
        this.context = context;
    }

    @Override
    public void onListen(Object arguments, EventChannel.EventSink events) {
        events.success("event");
        events.success("辛苦了");
    }

    @Override
    public void onCancel(Object arguments) {
        Log.d("asdf2", arguments.toString());
    }
}
