package com.fly.fox.project.utils

import android.content.Context
import android.widget.Button
import android.widget.EditText


/**
 * 用于根据输入框的状态来判断 设置button状态 的扩展函数
 */
fun Button.enable(ed:EditText,methon:() ->Boolean){
    val button = this
    ed.addTextChangedListener(object :DefaultTextWatcher(){
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            button.isEnabled = methon()
        }
    })
}

/**
 * 高级函数改造接口回调,万能接口回掉
 */
var listener: ((Any) -> Unit)? = null

fun Context.setCallBack(block: (Any) -> Unit) {
    listener = block
}
