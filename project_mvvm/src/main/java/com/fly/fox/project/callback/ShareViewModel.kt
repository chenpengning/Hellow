package com.fly.fox.project.callback

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShareViewModel : ViewModel() {

    var flag = MutableLiveData<Boolean>()
}