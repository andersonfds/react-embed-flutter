package com.example.myapp.channel;

import android.app.Activity;
import android.content.Intent;

import androidx.annotation.NonNull;

import com.example.myapp.MainFlutterActivity;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class ReactNativeFlutterBridgeChannel extends ReactContextBaseJavaModule {

    public ReactNativeFlutterBridgeChannel(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @NonNull
    @Override
    public String getName() {
        return "Flutter";
    }

    @ReactMethod
    public void navigateTo(String screen) {
        final Activity activity = getReactApplicationContext().getCurrentActivity();
        final Intent intent = new Intent(activity, MainFlutterActivity.class);
        intent.putExtra("flutterScreen", screen);
        if (activity != null) {
            activity.startActivity(intent);
        }
    }
}
