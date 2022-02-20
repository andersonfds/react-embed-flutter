package com.example.myapp.channel;

import android.content.Intent;

import androidx.annotation.NonNull;

import com.example.myapp.MainFlutterActivity;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.util.Objects;

import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngineCache;

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
        final Intent intent =
                FlutterActivity
                        .withCachedEngine("my_engine_id")
                        .build(Objects.requireNonNull(getCurrentActivity()));
        intent.setClass(getCurrentActivity(), MainFlutterActivity.class);
        intent.setAction("push_a_route");
        intent.putExtra("navigate_to", screen);
        getCurrentActivity().startActivity(intent);
        getCurrentActivity().overridePendingTransition(0,0);
    }
}
