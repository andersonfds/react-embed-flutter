package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapp.channel.FlutterMethodChannel;

import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodChannel;

public class MainFlutterActivity extends FlutterActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String action = intent.getAction();
        String route = intent.getStringExtra("navigate_to");

        // Example action
        boolean routeIntent = action != null && action.equals("push_a_route");
        FlutterEngine engine = getFlutterEngine();

        if (routeIntent && engine != null) {
            // Pushing a new route when new intent received
            // engine.getNavigationChannel().
        }
    }

    @Override
    public void configureFlutterEngine(@NonNull FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        new MethodChannel(flutterEngine.getDartExecutor().getBinaryMessenger(), "react_native_channel")
                .setMethodCallHandler(new FlutterMethodChannel(this));
    }
}
