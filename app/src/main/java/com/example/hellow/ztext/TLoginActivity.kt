package com.example.hellow.ztext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.hellow.R

class TLoginActivity : AppCompatActivity() {

    private lateinit var  tLoginViewMode: TLoginViewMode

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_text)

        /**
         * 初始化viewmodel对象
         */
        tLoginViewMode = ViewModelProvider(this,ViewModelProvider.NewInstanceFactory()).get(TLoginViewMode::class.java)

        /**
         * 在View层进行数据的观察，用于对数据的更新，后续使用databinding，逻辑移除
         *
         */
        tLoginViewMode.logininfo.observe(this, Observer {

            it.forEach {

                Log.d("****","====name =${it.name}  pwd = ${it.pw}")
            }

        })


    }


    override fun onResume() {
        super.onResume()

        tLoginViewMode.loginMethon("jetpack","123456")
    }
}
