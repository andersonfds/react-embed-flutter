import 'package:flutter/services.dart';

class RnMethodChannel {
  static final _channel = new MethodChannel("react_native_channel");

  static Future<void> navigate(String route) async {
    return await _channel.invokeMethod("navigate", route);
  }
}
