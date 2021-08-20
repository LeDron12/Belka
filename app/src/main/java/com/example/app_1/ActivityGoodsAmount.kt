package com.example.app_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app_1.databinding.ActivityGoodsAmountBinding

class ActivityGoodsAmount : AppCompatActivity() {

    private lateinit var activityBinding : ActivityGoodsAmountBinding
    private var productsAdapter = AdapterGoodsAmount()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityBinding = ActivityGoodsAmountBinding.inflate(layoutInflater)
        setContentView(activityBinding.root)

        activityBinding.apply {
            rvProducts.layoutManager = LinearLayoutManager(this@ActivityGoodsAmount)
            rvProducts.adapter = productsAdapter
            //productsAdapter.fillList()
        }

    }
}