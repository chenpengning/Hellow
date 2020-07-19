package com.fly.fox.project.utils

import android.app.Application
import android.content.ComponentCallbacks
import android.content.Context
import android.content.res.Configuration
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

/**
 * 今日头条适配方案
 * 修改density值,强行把所有不同尺寸分辨率的手机的宽度dp值改成同一个值
 */

private var sNoncompatScaledDensity = 0f
private var sNoncompatDensity = 0f

fun Application.setCustomDensity() {

    val appDisplayMetrics = resources.displayMetrics

    if (sNoncompatDensity == 0f) {
        //系统的 density
        sNoncompatDensity = appDisplayMetrics.density
        //系统的 scaledDensity
        sNoncompatDensity = appDisplayMetrics.scaledDensity
        //监听系统字体改变的回调
        registerComponentCallbacks(object : ComponentCallbacks {
            override fun onLowMemory() {

            }

            override fun onConfigurationChanged(newConfig: Configuration) {
                if (newConfig != null && newConfig.fontScale > 0) {
                    sNoncompatScaledDensity = resources.displayMetrics.scaledDensity
                }
            }

        })

    }


    val targetDensity = appDisplayMetrics.widthPixels / 960

    val targetScaleDensity: Float = targetDensity * (sNoncompatScaledDensity / sNoncompatDensity)


    val targetDensityDpi = 160 * targetDensity

    appDisplayMetrics.density = targetDensity.toFloat()
    appDisplayMetrics.scaledDensity = targetScaleDensity
    appDisplayMetrics.densityDpi = targetDensityDpi
    /**
     *
     *   float targetDensity = appDisplayMetrics.widthPixels / 960;
    float targetScaleDensity = targetDensity * (sNoncompatScaledDensity / sNoncompatDensity);
    int targetDensityDpi = (int) (160 * targetDensity);
    appDisplayMetrics.density = targetDensity;
    appDisplayMetrics.scaledDensity = targetScaleDensity;
    appDisplayMetrics.densityDpi = targetDensityDpi;
     */


}
