package com.smartuniversitygp.smartuniversity.gcm;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.gcm.GcmListenerService;
import com.smartuniversitygp.smartuniversity.LoginActivity;

/**
 * Created by hossam on 6/25/16 .
 */

public class PushNotificationService extends GcmListenerService {
    @Override
    public void onMessageReceived(String from, Bundle data) {
        String message = data.getString("message");
    }
}
