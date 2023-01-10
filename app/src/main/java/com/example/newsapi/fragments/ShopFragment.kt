package com.example.newsapi.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.room.Room
import com.example.newsapi.DatabaseClient
import com.example.newsapi.R
import com.example.newsapi.adapters.TreeRecyclerAdapter
import com.example.newsapi.databinding.FragmentShopBinding
import com.example.newsapi.models.Tree

class ShopFragment : Fragment() {

    private lateinit var bind: FragmentShopBinding
    private lateinit var seedlings:List<Tree>
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
        bind = FragmentShopBinding.inflate(layoutInflater)

        navController = NavHostFragment.findNavController(this)


        val databaseClient = context?.let {
            Room.databaseBuilder(
                it.applicationContext,
                DatabaseClient::class.java, "tek_database").fallbackToDestructiveMigration().allowMainThreadQueries().build()
        }
        if (databaseClient != null){
            seedlings = databaseClient.treeDao.getTrees()
        }
        bind.myRecView.apply {
            adapter = TreeRecyclerAdapter(seedlings, navController)
            layoutManager = GridLayoutManager(context, 1)
            hasFixedSize()
        }
        return bind.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ShopFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}