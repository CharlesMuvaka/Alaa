package com.example.newsapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.newsapi.databinding.ActivitySplashBinding
import com.example.newsapi.models.Tree
import com.example.newsapi.models.Vendor
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {
    lateinit var bind:ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(bind.root)

        val vendor = Vendor("Matthew Ochanda", "0763000000", "o@gmail.com", "Imara daima");
        val vendor1 =  Vendor("Kenny Rodgers", "0763000000", "o@gmail.com", "Karen junction");
        val vendor2 = Vendor("Matthew Omondi", "0763000000", "o@gmail.com", "Ongata Rongai");
        val vendor3 =  Vendor("Dennis Kioko", "0763000000", "o@gmail.com", "Git merge");
        val vendor4 =  Vendor("Victoria Amanda", "0763000000", "o@gmail.com", "Ole lenku");
        val vendor5 =  Vendor("Gilbert Ochieng", "0763000000", "o@gmail.com", "Kiserian");
        val vendor6 = Vendor("Charles Ndirang'u", "0763000000", "o@gmail.com", "Kayole East");
        val vendor7 =Vendor("Paul Gitonga", "0763000000", "o@gmail.com", "Donholm stage");
        val vendor8 = Vendor("Fidelis Nyagothie", "0763000000", "o@gmail.com", "Utawala East");
        val vendor9 = Vendor("Rose Chari", "0763000000", "o@gmail.com", "Ngong Road");

        val currentVendors = ArrayList<Vendor>()
        currentVendors.add(vendor)
        currentVendors.add(vendor1)
        currentVendors.add(vendor2)
        currentVendors.add(vendor3)
        currentVendors.add(vendor4)
        currentVendors.add(vendor5)
        currentVendors.add(vendor6)
        currentVendors.add(vendor7)
        currentVendors.add(vendor8)
        currentVendors.add(vendor9)

        val  tree = Tree("Acacia", "Carrica Pappaya");
        tree.image = R.drawable.seed1
        val tree1 =  Tree("Eucalyptus", "Shade Tree");
        tree1.image = R.drawable.seed2
        val tree2 =  Tree("Sycamore", "Cash crop tree");
        tree2.image = R.drawable.seed3;
        val tree3 =  Tree("Coconut", "Cash crop tree");
        tree3.image = R.drawable.seed4;
        val tree4 =  Tree("Blue gum", "Shade Tree");
        val tree5 =  Tree("Ginkgo", "Shade Tree");
        val tree6 =  Tree("Weeping Willow", "Cash crop tree");
        val tree7 =  Tree("Giant Sequoia", "Cash crop tree");
        val tree8 =  Tree("European Ash", "Carrica Pappaya");
        val tree9 =  Tree("White Oak", "Carrica Pappaya");

        val currentTrees = ArrayList<Tree>()
        currentTrees.add(tree)
        currentTrees.add(tree1)
        currentTrees.add(tree2)
        currentTrees.add(tree3)
        currentTrees.add(tree4)
        currentTrees.add(tree5)
        currentTrees.add(tree6)
        currentTrees.add(tree7)
        currentTrees.add(tree8)
        currentTrees.add(tree9)

        val databaseClient = Room.databaseBuilder(applicationContext,
            DatabaseClient::class.java, "tek_database").fallbackToDestructiveMigration().allowMainThreadQueries().build()

        val trees = databaseClient.treeDao.getTrees()

        for (i in 0 until currentTrees.size){
                if (trees.isEmpty()){
                    databaseClient.treeDao.addTree(currentTrees[i])
                    databaseClient.vendorDao.addVendor(currentVendors[i])

                }
        }

        Handler(Looper.getMainLooper()).postDelayed({
            val intent: Intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        },2000)
    }
}