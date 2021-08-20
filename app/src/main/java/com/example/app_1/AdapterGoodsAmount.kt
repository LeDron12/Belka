package com.example.app_1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.app_1.databinding.GoodsAmountDataBinding
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.FileAsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import jxl.Sheet
import jxl.Workbook
import jxl.WorkbookSettings
import jxl.read.biff.BiffException
import java.io.File


class AdapterGoodsAmount : RecyclerView.Adapter<AdapterGoodsAmount.GoodsHolder>() {

    val productList = ArrayList<ProductData>() //Fill array from excel
    val asyncHttpClient : AsyncHttpClient = AsyncHttpClient()
    lateinit var workbook

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
        //holder.bind(productList[position])
    }

    override fun getItemCount(): Int {
        return 5//productList.size
    }

    // TO DO TO DO TO DO TO DO TO DO TO DO TO DO TO DO TO DO TO DO TO DO TO DO
    fun fillList(){
        val URL : String = "https://github.com/LeDron12/Wolta/blob/master/Остатки.xls"
        asyncHttpClient.get(URL, object : FileAsyncHttpResponseHandler(this) {
            override fun onFailure(statusCode: Int, headers: Array<Header>, throwable: Throwable, file: File) {
               Toast.makeText(
                   this@MainActivity,
                    "Error in Downloading Excel File",
                    Toast.LENGTH_SHORT
                ).show()
                wait.setVisibility(View.GONE)
                progressBar.setVisibility(View.GONE)
            }

            override fun onSuccess(statusCode: Int, headers: Array<Header>, file: File) {
                val ws = WorkbookSettings()
                ws.gcDisabled = true
                if (file != null) {
                    //text.setText("Success, DO something with the file.");
                    wait.setVisibility(View.GONE)
                    progressBar.setVisibility(View.GONE)
                    try {
                        workbook = Workbook.getWorkbook(file)
                        val sheet: Sheet = workbook.getSheet(0)
                        //Cell[] row = sheet.getRow(1);
                        //text.setText(row[0].getContents());
                        for (i in 0 until sheet.rows) {
                            val row = sheet.getRow(i)
                            storyTitle.add(row[0].contents)
                            storyContent.add(row[1].contents)
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
        notifyDataSetChanged()
    }

}