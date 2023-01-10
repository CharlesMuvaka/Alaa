package com.example.newsapi.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class StkPush(
    @SerializedName("Business_Short_Code")
    @Expose
    val businessShortCode: String,
    @SerializedName("Password")
    @Expose
    val password: String,
    @SerializedName("Timestamp")
    val timeStamp:String,
    @SerializedName("Transaction_Type")
    val transactionType:String,
    @SerializedName("Amount")
    val amount:String,
    @SerializedName("Party_A")
    val partyA:String,
    @SerializedName("Party_B")
    val partyB:String,
    @SerializedName("Phone_Number")
    val phoneNumber:String,
    @SerializedName("CallBack_Url")
    val callBackUrl:String,
    @SerializedName("Account_Reference")
    val accountReference:String,
    @SerializedName("Transaction_Description")
    val transactionDescription:String) {
}