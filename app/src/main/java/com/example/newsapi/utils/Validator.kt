package com.example.newsapi.utils

import java.text.SimpleDateFormat
import java.util.*

class Validator {
    fun getTime():String{
        return SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault()).format(Date())
    }
    fun checkPhoneNumber(phoneNumber:String):String{
        if (phoneNumber == ""){
            return ""
        }
        if (phoneNumber.length < 11 && phoneNumber.startsWith("0")) {
            return phoneNumber.replace("^0", "254")
        }
        if (phoneNumber.length == 13 && phoneNumber.startsWith("+")){
            return phoneNumber.replace("^+", "")
        }
        return phoneNumber
    }


}