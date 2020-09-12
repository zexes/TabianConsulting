package com.zikozee.tabianconsulting.utility;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    public static final String TAG = "MyFirebaseMessagingServ";

    @Override
    public void onDeletedMessages() {
        super.onDeletedMessages();
    }


    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {

        String notificationBody ="";
        String notificationTitle ="";
        String notificationData ="";

        try{
            notificationData = remoteMessage.getData().toString();
            notificationTitle = remoteMessage.getNotification().getTitle();
            notificationTitle = remoteMessage.getNotification().getBody();
        }catch (NullPointerException e){
            Log.d(TAG, "onMessageReceived: NullPointerException: " + e.getMessage());
        }

        Log.d(TAG, "onMessageReceived: data: " + notificationData);
        Log.d(TAG, "onMessageReceived: notification body: " + notificationBody);
        Log.d(TAG, "onMessageReceived: notification title: " + notificationTitle);

    }

}
