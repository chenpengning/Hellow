package com.example.hellow.aidl

import android.app.Service
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Binder
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.hellow.R
import kotlinx.android.synthetic.main.activity_aidl.*
import java.util.ArrayList

class AidlActivity:AppCompatActivity() {


    companion object{
        const val TAG = "aidl"
    }

    private lateinit var binder : IDate

    private var binderFlag = false

    private var arraylisto = ArrayList<Student>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_aidl)


        mAidlBt.setOnClickListener {

            if (binderFlag){

                binder.addStudent(Student("liucehua"))

            }


        }

        mAidlBtquare.setOnClickListener{

              Log.d(TAG,"----list sise = ${binder.liststu.size}")
            if (binderFlag){
                
                Log.d(TAG,"----list sise = ${binder.liststu.size}")
                arraylisto = binder.liststu as ArrayList<Student>

                arraylisto.forEachIndexed{ index, student ->

                    Log.d(TAG,"---index=-${index}  == namme=${student.name}  student=${student}")

                }


            }

        }

        //绑定服务
        bindServier()


        textArraylist()


    }


    fun textArraylist(){

        var list = arrayListOf<String>()
        list.add("a")
        list.add("b")
        list.add("b")
        list.add("c")

        list.forEach {

            Log.d(TAG,"=====${it}")
        }


    }


    fun bindServier(){


        var intent = Intent()
        intent.`package` = "com.example.hellow"
        intent.action = "com.exanple.aidl.action"


        bindService(intent,object :ServiceConnection{
            override fun onServiceDisconnected(name: ComponentName?) {
                Log.d(TAG,"disconnect")
                binderFlag = false

            }

            override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
                binderFlag = true
                Log.d(TAG,"connecter success")
                binder = IDate.Stub.asInterface(service)


            }

        }, Context.BIND_AUTO_CREATE)
    }

    //第一种写法
//    var conn = object :ServiceConnection{
//        override fun onServiceDisconnected(name: ComponentName?) {
//
//
//
//
//        }
//
//        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
//
//
//        }
//
//    }



}