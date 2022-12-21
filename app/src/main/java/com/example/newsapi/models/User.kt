package com.example.newsapi.models

class User(private val name:String, private val phone:Int, private val email:String) {
    private var id:Int? = null
    private var location: String? = null
}