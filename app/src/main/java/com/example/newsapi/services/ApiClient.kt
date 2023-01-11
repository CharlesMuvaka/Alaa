package com.example.newsapi.services

import com.example.newsapi.interceptors.AuthInterceptor
import com.example.newsapi.models.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiClient {
    private lateinit var retrofit: Retrofit
    private var isDebug:Boolean = false
    private var isGetAccessToken:Boolean = false
    private lateinit var mAuthToken:String
    private val loginInterceptor = HttpLoggingInterceptor()

    fun setIsDebug(isDebug:Boolean):ApiClient{
        this.isDebug = isDebug
        return this
    }

    fun setAuthToken(authToken:String): ApiClient{
        this.mAuthToken = authToken
        return this
    }

    fun setGetAccessToken(accessToken:Boolean):ApiClient{
        this.isGetAccessToken = accessToken
        return this
    }

    private fun getOkHttPClient(): OkHttpClient.Builder{

        val okHttpClient = OkHttpClient.Builder()
        okHttpClient.connectTimeout(CONNECT_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .addInterceptor(loginInterceptor)

        return okHttpClient
    }

    private fun getRetrofitInstance(): Retrofit{

        val okHttpClient = getOkHttPClient()
        val builder = Retrofit.Builder().baseUrl(BASEURL).addConverterFactory(GsonConverterFactory.create())

        if (isDebug){
            loginInterceptor.level = HttpLoggingInterceptor.Level.BODY
        }

        if (mAuthToken.isNotEmpty()){
            okHttpClient.addInterceptor(AuthInterceptor(mAuthToken))
        }

        builder.client(okHttpClient.build())
        retrofit = builder.build()

        return retrofit
    }

    fun MpesaPayment():StkPushService{
        return getRetrofitInstance().create(StkPushService::class.java)
    }
}