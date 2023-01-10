package com.example.newsapi.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
class User(@ColumnInfo(name = "user_name") val name:String, val phone:Int, val email:String) :java.io.Serializable{
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null
    var location: String? = null
}