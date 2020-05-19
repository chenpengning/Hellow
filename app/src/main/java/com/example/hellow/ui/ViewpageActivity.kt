package com.example.hellow.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hellow.R
import kotlinx.android.synthetic.main.activity_viewpage.*

class ViewpageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewpage)

        var manager  = supportFragmentManager
        var tr = manager.beginTransaction()

        button.setOnClickListener {

            tr.add(R.id.fl_content,BaseFragment.getInstance())
            tr.commit()
        }



    }
}
