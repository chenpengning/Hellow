package com.fly.fox.project.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.fly.fox.project.R
import com.lzf.easyfloat.EasyFloat
import kotlinx.android.synthetic.main.fragment_first.*

class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bt_sender.setOnClickListener {

            bubbleView.let {

                it.setDefaultDrawableList()
                //设置缩放动画最大最小比例
                //it.setScaleAnimation(1f,1f)
                //设置两个上升动画之间的时间间隔
                it.setAnimationDelay(500)

                it.setItemViewWH(50, 50)
                //设置上升动画持续时间
                it.setRiseDuration(2000)
                it.setBottomPadding(0)
                it.setMaxHeartNum(1)
                it.setMinHeartNum(1)
                it.startAnimation(it.measuredWidth, it.measuredHeight)
            }

        }

        button1.setOnClickListener {

            EasyFloat.hideAppFloat()
        }

    }

}
