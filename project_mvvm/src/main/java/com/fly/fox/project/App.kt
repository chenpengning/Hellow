package com.fly.fox.project

import android.app.Activity
import android.app.Application
import android.content.Context
import android.util.Log
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import com.lzf.easyfloat.EasyFloat
import com.yhao.floatwindow.FloatWindow
import com.yhao.floatwindow.PermissionListener
import com.yhao.floatwindow.Screen


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
        EasyFloat.init(this, true)

    }

    private fun initFloatWindow() {

        var imageView = ImageView(applicationContext)
        imageView.setBackgroundResource(R.drawable.ic_favorite_blue_900_24dp)

        FloatWindow
            .with(applicationContext)
            .setView(imageView)
            .setWidth(100)                               //设置控件宽高
            .setHeight(Screen.width, 0.2f)
            .setX(100)                                   //设置控件初始位置
            .setY(Screen.height, 0.3f)
            //                .setDesktopShow(true)                        //桌面显示
            //                .setViewStateListener(mViewStateListener)    //监听悬浮控件状态改变
            .setPermissionListener(mPermissionListener)  //监听权限申请结果
            .build()
    }


    private val mPermissionListener = object : PermissionListener {
        override fun onSuccess() {
            Log.d("xxx", "onSuccess")
        }

        override fun onFail() {
            Log.d("xxx", "onFail")
        }
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