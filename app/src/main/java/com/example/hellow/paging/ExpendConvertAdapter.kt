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
import com.example.hellow.paging.room_conver.ConcertBean
import com.example.hellow.utils.LogUtil


class ExpendConvertAdapter() :
    PagedListAdapter<ConcertBean, ExpendConvertAdapter.ConverHolder>(diffUtil) {


    companion object {

        var diffUtil = object : DiffUtil.ItemCallback<ConcertBean>() {
            override fun areItemsTheSame(oldItem: ConcertBean, newItem: ConcertBean): Boolean {

                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ConcertBean, newItem: ConcertBean): Boolean {
                return oldItem.equals(newItem)
            }

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConverHolder {

        val view = DataBindingUtil.inflate<ItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item,
            parent,
            false
        )

        return ConverHolder(view)

    }

    override fun onBindViewHolder(holder: ConverHolder, position: Int) {
        holder.bind(getItem(position))

    }

    class ConverHolder(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.setClickListener {

                LogUtil.logd("=====onclick item view ...")
            }



//            binding.linearLayout.setOnClickListener {
//                LogUtil.logd("=====onclick item view ...")
//
//            }
        }



        fun bind(concert: ConcertBean?){

            with(binding){
                item = concert
                executePendingBindings()
            }

//            binding?.let {
//                it.item = concert
//                it.executePendingBindings()
//
//            }



        }



    }
}