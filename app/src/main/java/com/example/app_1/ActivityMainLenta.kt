package com.example.app_1


import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app_1.databinding.ActivityMainLentaBinding
import com.example.app_1.databinding.FragmentLeftoversBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.FileAsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import jxl.Sheet
import jxl.Workbook
import jxl.WorkbookSettings
import jxl.read.biff.BiffException
import java.io.File
import java.io.IOException


class ActivityMainLenta : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("PRODUCTS", "лента")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_lenta)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView5) as NavHostFragment
        val navController = navHostFragment.navController
        bottomNavigationView.setupWithNavController(navController)

        bottomNavigationView.setOnNavigationItemReselectedListener {
            when (it.itemId) {
                R.id.leftovers -> {
                    loadFragment(Leftovers())
                    return@setOnNavigationItemReselectedListener
                }
                R.id.catalog -> {
                    loadFragment(Catalog())
                    return@setOnNavigationItemReselectedListener
                }
                R.id.news -> {
                    loadFragment(News())
                    return@setOnNavigationItemReselectedListener
                }
                R.id.pricelist -> {
                    loadFragment(Pricelist())
                    return@setOnNavigationItemReselectedListener
                }
                R.id.purchases -> {
                    loadFragment(Purchases())
                    return@setOnNavigationItemReselectedListener
                }
            }
        }


    }

    private fun loadFragment(fragment: Fragment) {
        // load fragment
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    //val asyncHttpClient : AsyncHttpClient = AsyncHttpClient()
    //lateinit var workbook : Workbook

}
