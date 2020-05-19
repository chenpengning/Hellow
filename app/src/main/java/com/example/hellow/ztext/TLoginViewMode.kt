package com.example.hellow.ztext

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TLoginViewMode:ViewModel() {

    //登陆的信息
    var logininfo = MutableLiveData<List<LoginBean>>()



    /**
     * 方法的中间商，但是没有差价
     */
    fun loginMethon(name:String,pwd :String){

        TLoginDepository.getInstance().loggin(logininfo,name,pwd)

    }


}