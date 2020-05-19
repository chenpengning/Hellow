package com.example.hellow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.hellow.aidl.AidlActivity
import com.example.hellow.kotlin.LoginFragment
import com.example.hellow.mvp.Login2Activity
import kotlinx.android.synthetic.main.activity_scond.*

class ScondActivity : AppCompatActivity() {


    private lateinit var model :ViewModeText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scond)


        model = ViewModelProviders.of(this).get(ViewModeText::class.java)

        mbutton_lifecyle.setOnClickListener {

            startActivity(Intent(MainActivity@this,LifecycleTextActivity::class.java))

            model.mName.value = "Hello World viewmode"


        }

        mbutton_mvp.setOnClickListener {

            startActivity(Intent(MainActivity@this,Login2Activity::class.java))
        }


        model.mName.observe(this, Observer {

            mVmText.text = it
        })



        //测试Aidl
        mbutton_aidl.setOnClickListener {

            startActivity(Intent(ScondActivity@this,AidlActivity::class.java))
        }




    }
}
