package com.example.hellow.navigation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hellow.R
import com.example.hellow.paging.ui.TRecycleViewAdapter
import kotlinx.android.synthetic.main.activity_recycle_view.*

class News1Fragment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_recycle_view,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var list = ArrayList<String>()
        list.add("999999")
        list.add("666666")
        list.add("888888")
        list.add("999999")
        list.add("666666")
        list.add("888888")
        list.add("999999")
        list.add("666666")
        list.add("888888")
        list.add("666666")
        list.add("888888")
        list.add("999999")
        list.add("666666")
        list.add("888888")




        page_mRecyclyview.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)

        page_mRecyclyview.adapter = TRecycleViewAdapter(list)
    }
}