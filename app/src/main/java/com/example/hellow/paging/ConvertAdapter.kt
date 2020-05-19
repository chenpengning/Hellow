package com.example.hellow.paging

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.hellow.R
import com.example.hellow.databinding.ItemBinding
import com.example.hellow.utils.LogUtil


class ConvertAdapter() : PagedListAdapter<Concert, ConvertAdapter.ConverHolder>(diffUtil) {


    companion object{

         var diffUtil = object :DiffUtil.ItemCallback<Concert>(){
            override fun areItemsTheSame(oldItem: Concert, newItem: Concert): Boolean {

                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Concert, newItem: Concert): Boolean {
                return oldItem.equals(newItem)
            }

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConverHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)

        return ConverHolder(view)

    }

    override fun onBindViewHolder(holder: ConverHolder, position: Int) {



        var view = getItem(position)

        if(view == null ){
            holder.tv_id.text = "数据加载中......"
            holder.tv_name.text = "数据加载中......"

        }else {

            holder.tv_id.text = view.id.toString()
            holder.tv_name.text = view.name

        }



    }


    class ConverHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var tv_id : TextView = itemView.findViewById(R.id.pg_item_id)
        var tv_name : TextView = itemView.findViewById(R.id.pg_item_name)

    }

//    class ConverHolder(private val binding: ItemBinding):RecyclerView.ViewHolder(binding.root){
//
//        init {
//            binding.setOnclick {
//
//                LogUtil.logd("=====onclick item view ...")
//            }
//        }
//
//    }
}