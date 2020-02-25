package com.example.jsonlibrary

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.data_row.view.*

class MainAdapter(val homeFeed: HomeFeed) : RecyclerView.Adapter<CustomViewHolder>(){
    override fun getItemCount(): Int {
        return homeFeed.hobbies.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater=LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.data_row, parent,false)
        return  CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val hobby = homeFeed.hobbies.get(position)
        holder?.view?.data_row_data?.text = hobby.hobby
    }
}
class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view){

}