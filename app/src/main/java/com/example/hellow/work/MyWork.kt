package com.example.hellow.work

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.hellow.utils.LogUtil

class MyWork :Worker {

    var workerParams :WorkerParameters

    @SuppressLint("RestrictedApi")
    override fun doWork(): Result {

        LogUtil.logd("work = ${inputData.getString("work")}")


        var data = Data.Builder().putString("working","===from work ......").build()

        return Result.success(data)
    }

    constructor(context: Context, workerParams :WorkerParameters) : super(context, workerParams){



        this.workerParams = workerParams

    }



}