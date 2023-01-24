package com.example.newsapi.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import androidx.room.Room
import com.example.newsapi.DatabaseClient
import com.example.newsapi.R
import com.example.newsapi.adapters.VendorsRecAdapter
import com.example.newsapi.databinding.FragmentVendorBinding
import com.example.newsapi.databinding.FragmentVendorsBinding
import com.example.newsapi.models.Tree
import com.example.newsapi.models.Vendor
import kotlinx.coroutines.launch

class VendorsFragment : Fragment() {
    private lateinit var bind: FragmentVendorsBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bind = FragmentVendorsBinding.inflate(layoutInflater)
        navController =  NavHostFragment.findNavController(this)

        var vendors  = ArrayList<Vendor>()
        val databaseClient = context?.let {
            Room.databaseBuilder(
                it.applicationContext,
                DatabaseClient::class.java, "tek_database").fallbackToDestructiveMigration().allowMainThreadQueries().build()
        }


            if (databaseClient != null) {
                vendors  = databaseClient.vendorDao.getVendors() as ArrayList<Vendor>
            }

        var adp = VendorsRecAdapter(vendors,navController)

        bind.myRecView.apply {
            adapter = adp
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        }
        return bind.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            VendorsFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}