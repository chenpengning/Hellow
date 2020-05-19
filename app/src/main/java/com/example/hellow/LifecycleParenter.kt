package com.example.hellow

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class LifecycleParenter :LifecycleObserver {


    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onStartX(){

        Log.d("***","-------onstart")


    }


    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResumX(){

        Log.d("***","-------onresum")

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStopX(){
        Log.d("***","-------onstop")


    }



}