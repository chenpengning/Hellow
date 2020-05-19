package com.example.hellow.databinding

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.hellow.utils.LogUtil


@BindingAdapter("app:goneUnless")
fun goneUnless(view: View, visible: Boolean) {
    view.visibility = if (visible) View.VISIBLE else View.GONE
}


@BindingAdapter("app:imageUrl")
fun showImage(imageView: ImageView, url: String?) {

    LogUtil.logd("===imageView=$imageView == $url")

}
