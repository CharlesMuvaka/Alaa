package com.example.newsapi.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.newsapi.databinding.ActivityTreeBinding
import com.example.newsapi.models.Tree

class TreeRecyclerAdapter(private val trees: ArrayList<Tree>, private val context: Context): RecyclerView.Adapter<TreeRecyclerAdapter.MyHolder>() {

   inner class MyHolder(private val bind: ActivityTreeBinding):ViewHolder(bind.root) {

       fun setData(tree: Tree){
           bind.name.text = tree.name
           bind.description.text = tree.description
           tree.image?.let { bind.image.setImageResource(it) }
       }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val v: ActivityTreeBinding = ActivityTreeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyHolder(v)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.setData(trees[position])
    }

    override fun getItemCount() = trees.size
}