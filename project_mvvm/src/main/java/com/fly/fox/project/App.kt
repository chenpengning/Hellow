package com.fly.fox.project

import android.app.Activity
import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner

class App : Application(), ViewModelStoreOwner {


    override fun getViewModelStore(): ViewModelStore {
        return mAppViewModelStore
    }


    private var mFactory: ViewModelProvider.Factory? = null
    private lateinit var mAppViewModelStore: ViewModelStore

    companion object{

        lateinit  var instance : Context
    }

    override fun onCreate() {
        super.onCreate()
        instance  = this
    }

    fun getAppViewModelProvider(activity: Activity): ViewModelProvider {
        return ViewModelProvider(
            activity.applicationContext as App,
            (activity.applicationContext as App).getAppFactory(activity)
        )
    }

    private fun getAppFactory(activity: Activity): ViewModelProvider.Factory {
        val application = checkApplication(activity)
        if (mFactory == null) {
            mFactory = ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        }
        return mFactory as ViewModelProvider.Factory
    }

    private fun checkApplication(activity: Activity): Application {
        return activity.application
            ?: throw IllegalStateException("Your activity/fragment is not yet attached to " + "Application. You can't request ViewModel before onCreate call.")
    }


}