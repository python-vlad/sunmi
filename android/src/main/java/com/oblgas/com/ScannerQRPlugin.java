package com.oblgas.com;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "ScannerQR")
public class ScannerQRPlugin extends Plugin {

    private final BroadcastReceiver QRCODE_SUNMI = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String QRData = intent.getStringExtra("data");
            notifyListeners("BroadcastReceiverEvent", new JSObject().put("result", QRData));
        }
    };

    @Override
    public void load() {
        super.load();

        try {
            getContext().unregisterReceiver(QRCODE_SUNMI);
        } catch (Exception ignored) {
        }
        getContext().registerReceiver(QRCODE_SUNMI, new IntentFilter("com.sunmi.scanner.ACTION_DATA_CODE_RECEIVED"));
    }
}
