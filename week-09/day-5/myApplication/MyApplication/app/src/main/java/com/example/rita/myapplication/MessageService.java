package com.example.rita.myapplication;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Rita on 2016-12-23.
 */
public interface MessageService {
    @GET("/messages")
    Call<List<Message>> getMessageCall();
    @POST("/messages")
    Call<ResponseBody> postMessageCall(@Body MessageWrapper pw);
}
