package com.example.newsapi.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.newsapi.R
import com.example.newsapi.databinding.ActivityVendorBinding
import com.example.newsapi.fragments.ShopFragment
import com.example.newsapi.fragments.TreeFragment
import com.example.newsapi.models.Vendor

class VendorsRecAdapter(private val vendors:List<Vendor>, private val cont:NavController): RecyclerView.Adapter<VendorsRecAdapter.MyHolder>() {

    inner class MyHolder(private val bind:ActivityVendorBinding):ViewHolder(bind.root){

        fun setData(vendor:Vendor){
            bind.vendorName.text = vendor.name
            bind.vendorStatus.text = vendor.location

            bind.root.setOnClickListener{
                cont.navigate(R.id.action_vendorsFragment_to_vendorInfoFragment)
            }
        }



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val v:ActivityVendorBinding  = ActivityVendorBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyHolder(v)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.setData(vendors[position])

    }

    override fun getItemCount() = vendors.size
}