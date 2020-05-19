package com.example.hellow.paging.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.VERTICAL
import androidx.recyclerview.widget.RecyclerView
import com.example.hellow.R
import kotlinx.android.synthetic.main.activity_recycle_view.*

class RecycleViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle_view)


        var list = ArrayList<String>()
        list.add("999999")
        list.add("666666")
        list.add("888888")


        page_mRecyclyview.layoutManager = LinearLayoutManager(this, VERTICAL,false)

        page_mRecyclyview.adapter = TRecycleViewAdapter(list)


    }
}
