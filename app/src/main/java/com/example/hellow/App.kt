package com.example.hellow

import android.app.Application
import android.content.Context

class App:Application() {


    override fun onCreate() {
        super.onCreate()

        instance = applicationContext
    }

    companion object{

        lateinit var instance:Context

    }








}