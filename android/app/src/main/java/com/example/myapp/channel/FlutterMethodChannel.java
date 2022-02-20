package com.example.myapp.channel;


import android.app.Activity;
import android.content.Intent;

import androidx.annotation.NonNull;

import com.example.myapp.MainActivity;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public class FlutterMethodChannel implements MethodChannel.MethodCallHandler {

    private Activity activity;

    public FlutterMethodChannel(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void onMethodCall(@NonNull MethodCall call, @NonNull MethodChannel.Result result) {
        activity.startActivity(new Intent(activity, MainActivity.class));
        activity.overridePendingTransition(0,0);
    }
}