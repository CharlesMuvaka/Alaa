package com.example.newsapi.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.newsapi.R
import com.example.newsapi.databinding.ActivityVendorBinding
import com.example.newsapi.fragments.ShopFragment
import com.example.newsapi.fragments.TreeFragment
import com.example.newsapi.models.Vendor

class VendorsRecAdapter(private val cont:Context): RecyclerView.Adapter<VendorsRecAdapter.MyHolder>() {
    private lateinit var vendorList:List<Vendor>

    inner class MyHolder(private val bind:ActivityVendorBinding):ViewHolder(bind.root){
        init {
            bind.root.setOnClickListener(View.OnClickListener {
                Toast.makeText(cont, "clicked", Toast.LENGTH_LONG).show()
                val fragment:ShopFragment = ShopFragment.newInstance("yees", "noo")
                NavHostFragment().findNavController().navigate(R.id.action_shopFragment_to_treeFragment)
            })
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val v:ActivityVendorBinding  = ActivityVendorBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyHolder(v)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 10
    }
}