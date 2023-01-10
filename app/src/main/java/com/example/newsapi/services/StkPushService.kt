package com.example.newsapi.services

import com.example.newsapi.models.AccessToken
import com.example.newsapi.models.StkPush
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface StkPushService {

    @POST("mpesa/stkpush/v1/processrequest")
    fun sendPushServiceRequest(@Body stkPush: StkPush): Call<StkPush>
    @GET("oauth/v1/generate?grant_type=client_credentials")
    fun getAccessToken():Call<AccessToken>
}