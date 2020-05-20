package com.fly.fox.project

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.fly.fox.project.adapter.CustomAdapter
import kotlinx.android.synthetic.main.activity_recycle.*

class RecycleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle)




        mRV.adapter =
            CustomAdapter(arrayListOf("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "L"))
        mRV.layoutManager = LinearLayoutManager(this)
    }
}