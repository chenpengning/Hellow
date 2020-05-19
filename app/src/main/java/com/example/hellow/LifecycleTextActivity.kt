package com.example.hellow


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

class LifecycleTextActivity : AppCompatActivity(){




    private lateinit var mode : ViewModeText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scond)

        mode = ViewModelProviders.of(this).get(ViewModeText::class.java)


        mode.mName.observe(this, Observer {


        })

    }





    init {

        lifecycle.addObserver(LifecycleParenter())


    }







}