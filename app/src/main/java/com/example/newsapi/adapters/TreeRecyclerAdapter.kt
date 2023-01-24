package com.example.newsapi.adapters

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.newsapi.R
import com.example.newsapi.databinding.ActivityTreeBinding
import com.example.newsapi.models.Tree

class TreeRecyclerAdapter(private val trees: List<Tree>, private val context: NavController): RecyclerView.Adapter<TreeRecyclerAdapter.MyHolder>() {

   inner class MyHolder(private val bind: ActivityTreeBinding):ViewHolder(bind.root) {

       fun setData(tree: Tree){
           bind.name.text = tree.name
           bind.description.text = tree.description
           tree.image?.let { bind.image.setImageResource(it) }

           bind.root.setOnClickListener{
               val bundle = Bundle().apply {
                   putSerializable("tree", tree)
               }

                context.navigate(R.id.action_shopFragment_to_treeFragment, bundle)
           }
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