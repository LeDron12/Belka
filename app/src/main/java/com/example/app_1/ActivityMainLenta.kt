package com.example.app_1


import android.os.Bundle
import android.view.View
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
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
                    val frag = Leftovers()
                    loadFragment(Leftovers(/*this@ActivityMainLenta*/))
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

    val asyncHttpClient : AsyncHttpClient = AsyncHttpClient()
    lateinit var workbook : Workbook

    //TODO: Andrey K.
    /*
    fun fillList(){
        val URL : String = "https://github.com/LeDron12/Wolta/blob/master/Остатки.xls"
        asyncHttpClient.get(URL, object : FileAsyncHttpResponseHandler(this@ActivityMainLenta) {
            override fun onFailure(statusCode: Int, headers: Array<Header>, throwable: Throwable, file: File) {
                Toast.makeText(
                    this@ActivityMainLenta,
                     "Error in Downloading Excel File",
                     Toast.LENGTH_SHORT
                    ).show()
                //wait.setVisibility(View.GONE)
                //progressBar.setVisibility(View.GONE)
            }

            override fun onSuccess(statusCode: Int, headers: Array<Header>, file: File) {
                val ws = WorkbookSettings()
                ws.gcDisabled = true
                if (file != null) {
                    //text.setText("Success, DO something with the file.");
                    //wait.setVisibility(View.GONE)
                    //progressBar.setVisibility(View.GONE)
                    try {
                        workbook = Workbook.getWorkbook(file)
                        val sheet: Sheet = workbook.getSheet(0)
                        //Cell[] row = sheet.getRow(1);
                        //text.setText(row[0].getContents());
                        //TODO: Переделать чтобы считывать по rows и запонять массив экземплярами ProductData
                        for (i in 0 until sheet.rows) { //идем по рядам (начнем со 2ого тк 0 и 1 - headers)
                            val row = sheet.getRow(i)
                            storyTitle.add(row[0].contents) // колонка 1 в ряду (storyTitle - массив(не создан))
                            storyContent.add(row[1].contents) // колонка 2 в ряду
                            thumbImages.add(row[2].contents)
                        }
                        showData()
                    } catch (e: IOException) {
                        e.printStackTrace()
                    } catch (e: BiffException) {
                        e.printStackTrace()
                    }
                }
            }
        })

        //for ()
        //notifyDataSetChanged()
    }
    */

}
