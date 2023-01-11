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


}