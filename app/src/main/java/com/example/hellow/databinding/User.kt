package com.example.hellow.databinding

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR


// data class User(var name:String,var age:String)
 class User:BaseObservable() {

    /**
     * 重写set方法
     */
    var name :String = ""
    set(value) {
        field = value

    }

    var url:String = ""

    @Bindable
    var age :String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.age)

        }


}