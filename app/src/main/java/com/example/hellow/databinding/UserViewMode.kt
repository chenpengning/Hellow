package com.example.hellow.databinding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewMode :ViewModel() {

    var user =  MutableLiveData<User>()

    

    var count = 70


    fun changAge(){
        var userbin = User()
        userbin.age = "${count++}"
        userbin.name = "liudehua ${count++}"
        userbin.url = "http://baidu.com/url= $count++"

        user.postValue(userbin)

    }
}