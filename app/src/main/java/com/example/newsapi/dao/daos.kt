package com.example.newsapi.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.newsapi.models.Tree
import com.example.newsapi.models.User
import com.example.newsapi.models.Vendor

@Dao
interface UserDao{
    @Insert
    fun addUser(user: User)
    @Query("select * from users")
    fun getUsers(): List<User>

}

@Dao
interface VendorDao{
    @Insert
    fun addVendor(vendor: Vendor)
    @Query("select * from vendors")
    fun getVendors(): List<Vendor>

}

@Dao
interface  TreeDao{
    @Insert
    fun addTree(tree: Tree)
    @Query("select * from trees")
    fun getTrees():List<Tree>
}