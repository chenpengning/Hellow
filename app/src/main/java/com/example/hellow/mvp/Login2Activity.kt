package com.example.hellow.mvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.hellow.R
import com.example.hellow.mvp.netwok.ApiClient
import kotlinx.android.synthetic.main.activity_login2.*
import rx.Scheduler

class Login2Activity : AppCompatActivity() {


    companion object{

        private const val TAG = "login"

    }

    /**
     *
     * wanwone123456
     *
     * 123456
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)

        mLogin.setOnClickListener(listener)
        mRegiste.setOnClickListener(listener)


        ApiClient.instance.userApi().login("","")

    }


    private var listener = View.OnClickListener(){

        when(it.id){

            R.id.mLogin -> Log.d(TAG,"-----name = ${mName.text.toString()}")

            R.id.mRegiste -> Log.d(TAG,"------mpassword=${mPassword.text.toString()}")

        }

    }
}
