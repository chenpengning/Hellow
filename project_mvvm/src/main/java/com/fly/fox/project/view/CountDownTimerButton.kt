package com.fly.fox.project.view

import android.content.Context
import android.graphics.Color
import android.os.Handler
import android.os.Message
import android.util.AttributeSet
import android.view.View
import android.widget.Button

class CountDownTimerButton : Button, View.OnClickListener {


    constructor(context: Context?) : super(context)

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        setOnClickListener(this)
    }

    private var countTime = 6
    private val startText = "开始发送"
    private val countText = "倒计时"
    private val endText = "重新发送"

    private var hander = object : Handler() {

        override fun handleMessage(msg: Message) {
            this@CountDownTimerButton.let {
                it.text = countTime.toString() + countText
                it.isEnabled = false
                it.setBackgroundColor(Color.GRAY)
            }
            countTime--
            if (countTime >= 0) {
                sendEmptyMessageDelayed(1, 1000)
            } else {
                removeMessages(1)
                this@CountDownTimerButton.let {
                    it.text = endText
                    it.isEnabled = true
                    it.setBackgroundColor(Color.BLUE)
                }
            }
        }
    }

    override fun onClick(v: View?) {
        mOnClickListener?.onClick(v)

        countTime = 6
        hander.sendEmptyMessage(1)
    }


    fun reSetState(){
        countTime = 6
        this@CountDownTimerButton.let {
            it.text = startText
            it.isEnabled = true
            it.setBackgroundColor(Color.BLUE)
        }

    }

    fun startState(){
        countTime = 6
        this@CountDownTimerButton.let {
            it.text = startText
            it.isEnabled = true
            it.setBackgroundColor(Color.BLUE)
        }
    }







    private var mOnClickListener: OnClickListener? = null
    /**
     * 对外提供的点击事件
     */
    override fun setOnClickListener(l: OnClickListener?) {

        if (l is CountDownTimerButton) super.setOnClickListener(l) else mOnClickListener = l

    }


}