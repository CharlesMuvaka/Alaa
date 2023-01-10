package com.example.newsapi.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "trees")
data class Tree( @ColumnInfo(name = "tree_name")val name:String, @ColumnInfo(name = "tree_species")val species:String): java.io.Serializable{
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
    @ColumnInfo(name = "owner_id")
    var ownerId: Int = 0
    @ColumnInfo(name = "tree_description")
    var description: String? = null
    @ColumnInfo(name = "tree_image_url")
    var image: Int? = null
}
