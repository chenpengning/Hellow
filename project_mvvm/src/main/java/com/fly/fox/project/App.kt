package com.fly.fox.project

import android.app.Application
import android.content.Context

class App:Application() {

    companion object{

        lateinit  var instance : Context
    }

    override fun onCreate() {
        super.onCreate()

        instance  = this
    }
}