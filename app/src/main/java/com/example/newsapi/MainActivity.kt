package com.example.newsapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import androidx.core.view.GravityCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.newsapi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener{
    private lateinit var bind:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        bind.image3.setOnClickListener(this::onClick)

        val navHost:NavHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView2) as NavHostFragment
        bind.navView.bringToFront()
        bind.navView.setupWithNavController(navHost.navController)
    }

    override fun onClick(p0: View?) {
        if(p0 == bind.image3){
            bind.drawer.openDrawer(GravityCompat.START)
        }
    }
}