package com.example.hellow

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModeText:ViewModel() {

    val mName : MutableLiveData<String> by lazy {

        MutableLiveData<String>()
    }




    // Create a LiveData with a String
//    val currentName: MutableLiveData<String> by lazy {
//        MutableLiveData<String>()
//    }

}