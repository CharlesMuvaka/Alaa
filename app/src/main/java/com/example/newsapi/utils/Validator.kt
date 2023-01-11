package com.example.newsapi.utils

import java.text.SimpleDateFormat
import java.util.*

class Validator {
    fun getTime():String{
        return SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault()).format(Date())
    }

}