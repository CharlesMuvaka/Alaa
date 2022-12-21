package com.example.newsapi.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.newsapi.databinding.ActivityTreeBinding

class TreeRecyclerAdapter: RecyclerView.Adapter<TreeRecyclerAdapter.MyHolder>() {
   inner class MyHolder(private val bind: ActivityTreeBinding):ViewHolder(bind.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val v: ActivityTreeBinding = ActivityTreeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyHolder(v)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return 15
    }
}