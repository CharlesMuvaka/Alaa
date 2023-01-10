package com.example.newsapi.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class AccessToken(@SerializedName("access_token") @Expose val accessToken: String, @SerializedName("expires_in") @Expose val expiresIn: String) {
}