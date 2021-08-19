package com.example.app_1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app_1.databinding.GoodsAmountDataBinding

class AdapterGoodsAmount : RecyclerView.Adapter<AdapterGoodsAmount.GoodsHolder>() {

    val productList = ArrayList<GoodsAmountData>() //Fill array from excel

    class GoodsHolder(view : View) : RecyclerView.ViewHolder(view){

        val binding = GoodsAmountDataBinding.bind(view)

        fun bind(product : GoodsAmountData) = with(binding){
            tvBarCode1.text = "$tvBarCode1.text ${product.barcode.toString()}"
            //so on
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoodsHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.goods_amount_data, parent, false)
        return GoodsHolder(view)
    }

    override fun onBindViewHolder(holder: GoodsHolder, position: Int) {
        holder.bind(productList[position])
    }

    override fun getItemCount(): Int {
        return productList.size
    }
}