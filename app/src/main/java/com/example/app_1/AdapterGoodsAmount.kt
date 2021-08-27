package com.example.app_1

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.app_1.databinding.ActivityMainLentaBinding
import com.example.app_1.databinding.GoodsAmountDataBinding
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.FileAsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import jxl.Sheet
import jxl.Workbook
import jxl.WorkbookSettings
import jxl.read.biff.BiffException
import java.io.File
import java.io.IOException
import kotlin.coroutines.coroutineContext


class AdapterGoodsAmount(context: Context) : RecyclerView.Adapter<AdapterGoodsAmount.GoodsHolder>() {

    val productList = ArrayList<ProductData>() //Fill array from excel
    val asyncHttpClient : AsyncHttpClient = AsyncHttpClient()
    lateinit var workbook : Workbook
    var amlContext : Context = context

    class GoodsHolder(view : View) : RecyclerView.ViewHolder(view){

        val binding = GoodsAmountDataBinding.bind(view)

        fun bind(product : ProductData) = with(binding){
            tvBarCode1.text = "$tvBarCode1.text ${product.barcode.toString()}"
            tvDecxription1.text = "$tvDecxription1.text ${product.nomenclature}"
            tvVendorCode1.text = "$tvVendorCode1.text ${product.vendorCode}"
            tvCity1.text = "$tvCity1.text ${product.city}"
            tvReserved1.text = "$tvReserved1.text ${product.reserved}"
            tvAviliable1.text = "$tvAviliable1.text ${product.aviliable}"
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

    fun fillList(){
        val url : String = "https://github.com/LeDron12/Wolta/blob/master/Остатки.xls"
        Log.d("PRODUCTS", "РАБОТАЮ")

        asyncHttpClient.get(url, object : FileAsyncHttpResponseHandler(amlContext) {
            override fun onFailure(statusCode: Int, headers: Array<Header>, throwable: Throwable, file: File) {
                Toast.makeText(
                    amlContext,
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
                    Log.d("PRODUCTS", "OnSucsessBefore1$productList")
                    try {
                        workbook = Workbook.getWorkbook(file)
                        val sheet: Sheet = workbook.getSheet(0)
                        //Cell[] row = sheet.getRow(1);
                        //text.setText(row[0].getContents());
                        for (i in 2 until sheet.rows) { //идем по рядам (начнем со 2ого тк 0 и 1 - headers)
                            val row = sheet.getRow(i)
                            val product = ProductData(
                                row[0].contents.toLong(),
                                row[1].contents,
                                row[2].contents,
                                "Novosibirsk",
                                row[3].contents.toInt(),
                                row[4].contents.toInt()
                            )
                            productList.add(product)
                        }
                        Log.d("PRODUCTS", "OnSucsessAfter$productList")
                    } catch (e: IOException) {
                        e.printStackTrace()
                    } catch (e: BiffException) { // CAUSES THIS EXCEPTION
                        e.printStackTrace()
                    }
                }
            }
        })
        notifyDataSetChanged()
    }

}