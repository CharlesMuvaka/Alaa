package com.example.newsapi

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.newsapi.dao.TreeDao
import com.example.newsapi.dao.UserDao
import com.example.newsapi.dao.VendorDao
import com.example.newsapi.models.Tree
import com.example.newsapi.models.User
import com.example.newsapi.models.Vendor

@Database(entities = [Tree::class, Vendor::class, User::class], version = 1, exportSchema = false)
abstract class DatabaseClient: RoomDatabase() {
    abstract val userDao: UserDao
    abstract val vendorDao: VendorDao
    abstract  val treeDao: TreeDao
}