package com.example.hellow.annotation

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hellow.R

class AnnoTwoActivity : AppCompatActivity() {

    @MyAnnotation
    var vaue :String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anno_two)

       // injectValue(this)


    }

    fun  injectValue(activity: Activity){

        val cls = activity::class.java

        val obj = cls.newInstance()

        cls.declaredFields.forEach {


        }

    }


}
