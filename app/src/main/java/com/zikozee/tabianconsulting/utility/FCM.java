package com.zikozee.tabianconsulting.utility;

import com.zikozee.tabianconsulting.models.fcm.FirebaseCloudMessage;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

public interface FCM {

    @POST("send")
    Call<ResponseBody> send(
            @HeaderMap Map<String, String> headers,
            @Body FirebaseCloudMessage message
            );
}
