package com.example.jsonlibrary

import android.app.DownloadManager
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import org.w3c.dom.Text
import java.io.IOException

class DisplayList : AppCompatActivity() {

    override public fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_view_main.layoutManager = LinearLayoutManager(this)

        fetchJson()
    }
    private fun fetchJson(){
        val url = "https://api.myjson.com/bins/18r9ww"

        val request = Request.Builder().url(url).build()

        val client = OkHttpClient()
        client.newCall(request).enqueue(object: Callback {
            override fun onResponse(call: Call, response: Response) {
                val body = response.body?.string()
                println(body)

                val gson = GsonBuilder().create()
                val homeFeed = gson.fromJson(body,HomeFeed::class.java)

                runOnUiThread {
                    recycler_view_main.adapter=MainAdapter(homeFeed)
                }
            }
            override fun onFailure(call: Call, e: IOException) {
                println("Failed to execute")
            }
        })
    }
}

//class HomeFeed(val hobbies: List<Hobby>)
//class Hobby (val hobby: String)
