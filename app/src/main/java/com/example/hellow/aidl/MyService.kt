package com.example.hellow.aidl

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyService : Service() {
    override fun onBind(intent: Intent?): IBinder? {

        return Binder()
    }



    class Binder :IDate.Stub(){



        var list = arrayListOf<Student>()

        override fun basicTypes(
            anInt: Int,
            aLong: Long,
            aBoolean: Boolean,
            aFloat: Float,
            aDouble: Double,
            aString: String?
        ) {
        }

        override fun addStudent(student: Student) {

            list.add(student)

            Log.d("***","===${list.size}")



        }

        override fun getListstu(): ArrayList<Student> {

            return list

        }

    }






}
