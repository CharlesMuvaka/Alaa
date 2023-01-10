package com.example.newsapi.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import com.example.newsapi.R
import com.example.newsapi.databinding.FragmentVendorBinding

class VendorFragment : Fragment(), View.OnClickListener {
    lateinit var  bind: FragmentVendorBinding


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
        bind = FragmentVendorBinding.inflate(layoutInflater)
        bind.submit.setOnClickListener(this)
        bind.sign.setOnClickListener(this)

        
        return bind.root
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            VendorFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    override fun onClick(p0: View?) {
        if (bind.submit == p0){
            NavHostFragment.findNavController(this).navigate(R.id.action_vendorFragment_to_mainFragment)
        }else if (bind.sign == p0){
            NavHostFragment.findNavController(this).navigate(R.id.action_vendorFragment_to_signUpFragment)

        }
    }
}