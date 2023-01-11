package com.example.newsapi.interceptors

import android.util.Base64
import com.example.newsapi.BuildConfig
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class AccessTokenInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val consumerKey = BuildConfig.CONSUMER_KEY
        val consumerSecret = BuildConfig.CONSUMER_SECRET

        val keys = "$consumerKey : $consumerSecret"
        val request:Request = chain.request()
            .newBuilder()
            .addHeader("Authorization", "Basic ${Base64.encodeToString(keys.toByteArray(), Base64.NO_WRAP)}")
            .build()
        return chain.proceed(request)

    }


}