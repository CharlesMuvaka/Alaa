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

    fun getPassword(businessShortCode:String,passKey:String, timeStamp:String):String{
        val password = businessShortCode + passKey + timeStamp
        return android.util.Base64.encodeToString(password.toByteArray(), android.util.Base64.NO_WRAP)
    }


}