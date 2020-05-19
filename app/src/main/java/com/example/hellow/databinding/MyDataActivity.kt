package com.example.hellow.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.hellow.R
import kotlinx.android.synthetic.main.activity_my_data.*

class MyDataActivity : AppCompatActivity() {

    private lateinit var  databinding :ActivityMyData2Binding
    private lateinit var viewMode: UserViewMode

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_my_data)

        databinding = DataBindingUtil.setContentView(this,R.layout.activity_my_data2)

        viewMode = ViewModelProvider(this,ViewModelProvider.NewInstanceFactory())[UserViewMode::class.java]

//        var count = 70
//        var user = User()
//        myDataBindingBt.setOnClickListener {
//
//            user.age = "${count++}"
//            databinding.userbin = user
//        }

        //databinding 结合 viewmode 使用

        databinding.vm = viewMode

        //关键代码
        databinding.lifecycleOwner = this


//        myDataBindingBt.setOnClickListener {
//
//           viewMode.changAge()
//        }





    }
}
