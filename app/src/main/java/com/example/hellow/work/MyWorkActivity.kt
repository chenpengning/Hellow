package com.example.hellow.work

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.work.Data
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.example.hellow.R
import com.example.hellow.utils.LogUtil

class MyWorkActivity : AppCompatActivity() {

    val tag = javaClass.simpleName

//    val oneTimeWorkRequest  by lazy {
//
//        OneTimeWorkRequestBuilder<MyWork>().build()
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_work)




    }

    init {
        var oneTimeWorkRequest = OneTimeWorkRequestBuilder<MyWork>()
    }


    override fun onResume() {
        super.onResume()




    }

    /**
     * 单次任务
     */
    fun oneTimeWorkRequest(){

        var data = Data.Builder().putString("work","from Acitvity ...").build()

        var oneTimeWorkRequest = OneTimeWorkRequestBuilder<MyWork>()
        .setInputData(data)
            .build()



        WorkManager.getInstance(this)

            .enqueue(oneTimeWorkRequest)




        WorkManager.getInstance(this).getWorkInfoByIdLiveData(oneTimeWorkRequest.id)
            .observe(this, Observer {

                LogUtil.logd("acitivity = ${it.outputData.getString("working")}")

            } )

    }

    fun onTimeWorkLisenter(view: View) {

        when(view.id){

            R.id.onTimeWork ->oneTimeWorkRequest()



        }

    }
}
