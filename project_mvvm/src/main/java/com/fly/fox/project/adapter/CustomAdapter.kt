package com.fly.fox.project.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fly.fox.project.R
import com.fly.fox.project.utils.listener


/**
 * 自定义头部跟尾部的recycleview适配器
 */
class CustomAdapter(list: List<String>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    private var mList: MutableList<String> = ArrayList()

    /**
     * 高级函数改造接口回调
     */
//    private  lateinit  var listener : (Any) -> Unit
//    fun  setListener(block :(Any) -> Unit){
//        this.listener = block
//    }
    //-------

    init {
        mList.clear()
        mList.addAll(list)
    }

    companion object {
        const val HEADER = 0
        const val FOOT = 2
        const val NORMAL = 1


    }

    fun setData(list: List<String>) {

        mList.clear()
        mList.addAll(list)

        notifyDataSetChanged()

    }


    override fun getItemCount(): Int {

        return when {
            mList.isNullOrEmpty() -> 2
            else -> mList.size + 2
        }

    }

    override fun getItemViewType(position: Int): Int {

        return when (position) {
            0 -> HEADER
            mList.size + 2 -> FOOT
            else -> NORMAL

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (viewType) {
            HEADER -> ViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_header,
                    parent,
                    false
                )
                , HEADER
            )
            FOOT -> ViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_foot,
                    parent,
                    false
                )
                , FOOT
            )
            else -> ViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_view,
                    parent,
                    false
                )
                , NORMAL
            )
        }

    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        when (position) {
            //处理header 逻辑
            0 -> {
                //holder.foot.text = "到底部了。。。。"
                holder.bt1_header.setOnClickListener {
                    listener?.let { it1 -> it1("bt1_header click ....") }
                }



            }
            //处理foot 逻辑
            mList.size + 1 -> {
                // holder.foot.text = "到底部了。。。。"

            }

            //list的逻辑
            else -> {
                val name = mList[position - 1]

                holder.content.text = name

                holder.itemView.setOnClickListener {
                    //listener(position)
                    listener?.let { it1 -> it1(position) }
                }

            }


        }

    }


    class ViewHolder(itemView: View, viewType: Int) : RecyclerView.ViewHolder(itemView) {

        lateinit var content: TextView
        lateinit var header: LinearLayout
        lateinit var foot: TextView

        lateinit var bt1_header: Button

        init {
            when (viewType) {
                HEADER -> {
                    header = itemView.findViewById(R.id.ly_header)
                    bt1_header = header.findViewById(R.id.bt1_header)
                }
                FOOT -> foot = itemView.findViewById(R.id.tv_foot)
                else -> content = itemView.findViewById(R.id.tv_name)
            }


        }
    }


}