package com.example.newsapi.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import com.example.newsapi.R
import com.example.newsapi.databinding.FragmentSplashBinding


class SplashFragment : Fragment() {
    private lateinit var bind:FragmentSplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }

        Handler(Looper.getMainLooper()).postDelayed({
            NavHostFragment.findNavController(this).navigate(R.id.action_splashFragment_to_vendorFragment)
        }, 3000)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bind = FragmentSplashBinding.inflate(layoutInflater)


        return bind.root
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SplashFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}