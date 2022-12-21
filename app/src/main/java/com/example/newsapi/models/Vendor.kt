package com.example.newsapi.models

class Vendor(private val name:String, private val phone:Int, private val location:String) {
    private val id:Int? = null
    private var website: String? = null
    private var trees: List<Tree>? = null
}