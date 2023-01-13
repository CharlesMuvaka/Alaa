package com.example.newsapi.fragments

import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.get
import androidx.navigation.ui.setupWithNavController
import com.example.newsapi.R
import com.example.newsapi.databinding.FragmentMainBinding

class MainFragment : Fragment(), View.OnClickListener {
    private lateinit var  bind: FragmentMainBinding
    private lateinit var navHostFragment: NavHostFragment



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
        bind = FragmentMainBinding.inflate(layoutInflater)

        navHostFragment = childFragmentManager.findFragmentById(R.id.fragmentContainerView2) as NavHostFragment

        bind.image3.setOnClickListener(this::onClick)
        bind.navView.bringToFront()

        var fragment = navHostFragment.navController.currentDestination!!.label
        var graph = navHostFragment.navController.graph[R.id.treeFragment]
//        bind.slogan.text = "$fragment ${navHostFragment.id} "
//        bind.vendors.text = graph.id.toString()



        bind.navView.setupWithNavController(navHostFragment.navController)
        return bind.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MainFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }

    override fun onClick(p0: View?) {
        if (p0 == bind.image3){
            bind.drawer.openDrawer(GravityCompat.START)
        }
    }

}