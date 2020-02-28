package com.example.jsonlibrary

import android.app.DownloadManager
import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import org.w3c.dom.Text
import java.io.IOException

//public class DisplayLists:AppCompatActivity() {
//
//    public fun list(c: Context, message: String) {
//
//        Toast.makeText(c, message, Toast.LENGTH_LONG).show()
//
//        recycler_view_main.layoutManager = LinearLayoutManager(this)
//
//        val url = "https://api.myjson.com/bins/18r9ww"
//
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
//
//                runOnUiThread {
//                    recycler_view_main.adapter=MainAdapter(homeFeed)
//                }
//            }
//            override fun onFailure(call: Call, e: IOException) {
//                println("Failed to execute")
//            }
//        })
//
//    }
//}

class DisplayList : AppCompatActivity() {

    public fun list(c: Context, message: String):String{
        val words= listOf("pen","book","Item","money","xyz")
        var listJSON:String?=null
        val url = "https://api.myjson.com/bins/18r9ww"
        val request = Request.Builder().url(url).build()
        val client = OkHttpClient()
        client.newCall(request).enqueue(object: Callback{
            override fun onResponse(call: Call, response: Response) {
                val body = response?.body?.string()
//                var item:MutableList<String> = ArrayList()
//                for(i in 0 until body!!.length){
//                    item.add(body.getJSONObject(i))
//                }
//                listJSON=item.toString()
                val gson = GsonBuilder().create()
                val homeFeed = gson.fromJson(body,HomeFeed::class.java)
                listJSON=homeFeed.toString()
//                listJSON=body
            }
            override fun onFailure(call: Call, e: IOException) {
                listJSON="failed to fetch"
//                println("Failed to fetch")
//                return "failed"
            }
        })
//        return words.toString()
        return listJSON.toString()
//        Toast.makeText(c, message, Toast.LENGTH_LONG).show()
//        onCreate(savedInstanceState = null);
    }

//    override public fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        recycler_view_main.layoutManager = LinearLayoutManager(this)
//
//        fetchJson()
//    }
//    private fun fetchJson(){
//        val url = "https://api.myjson.com/bins/18r9ww"
//
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
//
//                runOnUiThread {
//                    recycler_view_main.adapter=MainAdapter(homeFeed)
//                }
//            }
//            override fun onFailure(call: Call, e: IOException) {
//                println("Failed to execute")
//            }
//        })
//    }
}

class HomeFeed(val hobbies: List<Hobby>)
class Hobby (val hobby: String)
