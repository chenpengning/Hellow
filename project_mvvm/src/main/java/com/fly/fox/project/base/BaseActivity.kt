package com.fly.fox.project.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.fly.fox.project.App
import com.fly.fox.project.callback.ShareViewModel


class BaseActivity : AppCompatActivity() {

    var shareViewModel: ShareViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        shareViewModel = getAppViewModelProvider().get(ShareViewModel::class.java)

    }


    // 2020 用法 ViewModelProvider
    protected fun getAppViewModelProvider(): ViewModelProvider {
        return (applicationContext as App).getAppViewModelProvider(this)
    }

    protected fun getActivityViewModelProvider(activity: AppCompatActivity): ViewModelProvider {
        return ViewModelProvider(activity, activity.defaultViewModelProviderFactory)
    }

}