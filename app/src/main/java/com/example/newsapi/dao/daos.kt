package com.example.newsapi.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.newsapi.models.User
import com.example.newsapi.models.Vendor

@Dao
interface UserDao{
    @Insert
    fun addUser(user: User)
    @Query("select * from users")
    fun getUsers(): List<User>

}

interface VendorDao{
    @Insert
    fun addVendor(vendor: Vendor)

}