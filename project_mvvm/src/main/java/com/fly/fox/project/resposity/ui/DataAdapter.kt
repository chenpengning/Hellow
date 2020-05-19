package com.fly.fox.project.resposity.ui


import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fly.fox.project.R
import com.fly.fox.project.resposity.room.Person

class DataAdapter : RecyclerView.Adapter<DataAdapter.ViewHolder>() {

    private lateinit var list: List<Person>


    fun setData(list: List<Person>){
        this.list = list

    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        holder.tvName.text = list[position].name



    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }


    class ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {

        var tvName = itemview.findViewById<TextView>(R.id.tv_name)

        init {
            itemview.setOnClickListener {
                Log.d("xxxx","view onclick .....")
            }


        }


    }
}