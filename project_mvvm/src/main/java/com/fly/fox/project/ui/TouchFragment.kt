package com.fly.fox.project.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.fly.fox.project.R
import com.fly.fox.project.adapter.CustomAdapter
import com.fly.fox.project.utils.setCallBack
import kotlinx.android.synthetic.main.fragment_touch.*


class TouchFragment : Fragment() {


    private var adapter: CustomAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_touch, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter =
            CustomAdapter(arrayListOf("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "L"))
        mRV.adapter = adapter

        mRV.layoutManager = LinearLayoutManager(context)



        context?.setCallBack {

            Log.d("xxxx", " onclick position = $it")
        }
    }


}
