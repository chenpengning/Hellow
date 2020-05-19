package com.example.order

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.qw.soul.permission.SoulPermission
import com.qw.soul.permission.bean.Permission
import kotlinx.android.synthetic.main.order_activity__main.*
import com.qw.soul.permission.callbcak.CheckRequestPermissionListener

import android.util.Log


class Order_MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.order_activity__main)

        callPhone.setOnClickListener {

            SoulPermission.getInstance()
                .checkAndRequestPermission(Manifest.permission.CALL_PHONE,
                    //if you want do noting or no need all the callbacks you may use SimplePermissionAdapter instead
                    object : CheckRequestPermissionListener {
                        override fun onPermissionOk(permission: Permission) {
                           Utils.makeCall(this@Order_MainActivity,"18576755876")
                        }

                        override fun onPermissionDenied(permission: Permission) {
                            Log.d("xxxx","=====没有权限。。。。。")
                        }
                    })

        }
    }





}
