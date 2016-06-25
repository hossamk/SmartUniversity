package com.smartuniversitygp.smartuniversity.gcm;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.gcm.GcmListenerService;

/**
 * Created by hossam on 6/25/16 .
 */

public class PushNotificationService extends GcmListenerService {
    @Override
    public void onMessageReceived(String from, Bundle data) {
        String message = data.getString("message");
        Toast.makeText(this, "message: " + message, Toast.LENGTH_LONG);
    }
}
