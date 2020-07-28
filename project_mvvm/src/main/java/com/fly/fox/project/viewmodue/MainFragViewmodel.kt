package com.fly.fox.project.viewmodue

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fly.fox.project.resposity.NetWorkResposity
import com.flyfox.newsclient.net.bean.LoginRes
import com.flyfox.newsclient.net.bean.ResponWrap

class MainFragViewmodel : ViewModel() {

    var name = MutableLiveData<String>()

    fun itemOnClick() {

    }

    var data = MutableLiveData<ResponWrap<LoginRes>>()

    fun login(name: String, pwd: String) {

        //NetWorkResposity.instance.login(name, pwd, data)
    }


    fun login1(name: String, pwd: String) {


        NetWorkResposity.instance.loginBody1(name, pwd)
            .subscribe({


            }, {

                it.printStackTrace()


            })
    }




}