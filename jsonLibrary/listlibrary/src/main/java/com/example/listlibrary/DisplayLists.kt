package com.example.listlibrary

import android.app.DownloadManager
import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.*
import org.w3c.dom.Text
import java.io.IOException

public class DisplayLists(){
    public fun list(){
        val url = "https://api.myjson.com/bins/18r9ww"
        println("Hello:"+url)
//        showToast(url,Toast.LENGTH_LONG)
//        val request = Request.Builder().url(url).build()
//
//        val client = OkHttpClient()
//        client.newCall(request).enqueue(object: Callback {
//            override fun onResponse(call: Call, response: Response) {
//                val body = response.body?.string()
//                println(body)
//
//                val gson = GsonBuilder().create()
//                val homeFeed = gson.fromJson(body,HomeFeed::class.java)

//                runOnUiThread {
//                    recycler_view_main.adapter=MainAdapterList(homeFeed)
//                }
//            }
//            override fun onFailure(call: Call, e: IOException) {
//                println("Failed to execute")
//            }
//        })
    }
}
class HomeFeed(val hobbies: List<Hobby>)
class Hobby (val hobby: String)
