package com.smartuniversitygp.smartuniversity.gcm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.gcm.GcmListenerService;
import com.smartuniversitygp.smartuniversity.LoginActivity;
import com.smartuniversitygp.smartuniversity.MainActivity;
import com.smartuniversitygp.smartuniversity.app.AppConfig;
import com.smartuniversitygp.smartuniversity.app.AppController;
import com.smartuniversitygp.smartuniversity.helper.SessionManager;
import com.smartuniversitygp.smartuniversity.helper.User;

import java.util.Date;

/**
 * Created by hossam on 6/25/16 .
 */

public class PushNotificationService extends GcmListenerService {
    public final static String TAG = GcmListenerService.class.getName();
    private NotificationUtils notificationUtils;

    @Override
    public void onMessageReceived(String from, Bundle bundle) {
        String title = bundle.getString("title");
        Boolean isBackground = Boolean.valueOf(bundle.getString("is_background"));
        String message = bundle.getString("message");
        Log.d(TAG, "From: " + from);
        Log.d(TAG, "title: " + title);
        Log.d(TAG, "isBackground: " + isBackground);
        Log.d(TAG, "message: " + message);


//        if(AppController.getInstance().getPrefManager().getUser() == null){
//            // user is not logged in, skipping push notification
//            Log.e(TAG, "user is not logged in, skipping push notification");
//            return;
//        }


        processPush(title, isBackground, message);

    }

    /**
     * Processing chat room push message
     * this message will be broadcasts to all the activities registered
     */
    private void processPush(String title, boolean isBackground, String message) {
        if (!isBackground) {

            Intent resultIntent = new Intent(getApplicationContext(), MainActivity.class);
            showNotificationMessage(getApplicationContext(), title, message, System.currentTimeMillis() + "", resultIntent);


        } else {
            // the push notification is silent, may be other operations needed
            // like inserting it in to SQLite
        }
    }

    /**
     * Showing notification with text only
     */
    private void showNotificationMessage(Context context, String title, String message, String timeStamp, Intent intent) {
        notificationUtils = new NotificationUtils(context);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        notificationUtils.showNotificationMessage(title, message, timeStamp, intent);
    }

    /**
     * Showing notification with text and image
     */
    private void showNotificationMessageWithBigImage(Context context, String title, String message, String timeStamp, Intent intent, String imageUrl) {
        notificationUtils = new NotificationUtils(context);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        notificationUtils.showNotificationMessage(title, message, timeStamp, intent, imageUrl);
    }
}