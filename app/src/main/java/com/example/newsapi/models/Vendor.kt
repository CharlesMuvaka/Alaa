package com.example.newsapi.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vendors")
data class Vendor(@ColumnInfo(name = "vendor_name")val name:String, @ColumnInfo(name = "vendor_phone")val phone:String,
             @ColumnInfo(name = "vendor_email")val email:String, @ColumnInfo(name = "vendor_location")val location:String):java.io.Serializable {
    @ColumnInfo(name = "vendor_id")
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null
    @ColumnInfo(name = "vendor_website")
    var website: String? = null
}