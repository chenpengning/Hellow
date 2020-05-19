package com.example.hellow.paging.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hellow.R
import com.example.hellow.utils.LogUtil

class TRecycleViewAdapter : RecyclerView.Adapter<TRecycleViewAdapter.MyHolerView> {



   var list = ArrayList<String>()

    constructor(list:ArrayList<String>) :super(){

        this.list = list

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolerView {

        var view = LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return MyHolerView(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyHolerView, position: Int) {
        holder.name.text = list[position]

        LogUtil.logd("-===${list[position]}")
    }


    class MyHolerView(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var name = itemView.findViewById<TextView>(R.id.pg_item_name)


    }
}