package com.example.app_1

import android.annotation.SuppressLint
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.app_1.databinding.ActivityMainLentaBinding
import org.jsoup.Jsoup
import org.w3c.dom.Document
import org.w3c.dom.DocumentFragment
import org.w3c.dom.DocumentType
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL

class ActivityMainLenta : AppCompatActivity() {

    private lateinit var mainLentaScreen : ActivityMainLentaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainLentaScreen = ActivityMainLentaBinding.inflate(layoutInflater)
        setContentView(mainLentaScreen.root)
        AsyncTaskExample(this).execute()
    }

    @SuppressLint("StaticFieldLeak")
    class AsyncTaskExample(private var activity: ActivityMainLenta?) : AsyncTask<String, String, String>() {

        override fun onPreExecute() {

        }

        override fun doInBackground(vararg p0: String?): String {
            val url = "https://www.wolta.ru/product/"
            var doc : org.jsoup.nodes.Document
            var result = ""
            try {
                doc = Jsoup.connect(url).get()
                result = doc.title()
                return result
            } catch (ex: Exception) {
                result = "error"
                return result
            }
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
        }
    }
}