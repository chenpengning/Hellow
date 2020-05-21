package com.fly.fox.project.view

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.fly.fox.project.R

class VolumeView : LinearLayout {


    private var animatorSet: AnimatorSet? = null
    private var view: View? = null

    constructor(context: Context?, attrs: AttributeSet?) : super(
        context,
        attrs
    ) {
        view = LayoutInflater.from(context).inflate(R.layout.volume, this, false)
        addView(view)

        animatorSet = AnimatorSet()

        startAnim()

    }


    fun cancelAnim() {

        animatorSet?.cancel()

    }

    fun startAnim() {

        val listAnis = ArrayList<Animator>()
        val tv1 = view?.findViewById<TextView>(R.id.tv1)
        val an = ObjectAnimator.ofFloat(tv1, "scaleY", 1f, 2f, 1f)
        an.repeatCount = ValueAnimator.INFINITE
        an.start()
        listAnis.add(an)

        val tv2 = view?.findViewById<TextView>(R.id.tv2)
        val an2 = ObjectAnimator.ofFloat(tv2, "scaleY", 1f, 2f, 1f)
        an2.repeatCount = ValueAnimator.INFINITE
        an2.startDelay = 200
        an2.start()
        listAnis.add(an2)

        val tv3 = view?.findViewById<TextView>(R.id.tv3)
        val an3 = ObjectAnimator.ofFloat(tv3, "scaleY", 1f, 2f, 1f)
        an3.repeatCount = ValueAnimator.INFINITE
        an3.startDelay = 400
        an3.start()
        listAnis.add(an3)

        animatorSet?.playTogether(listAnis)
        animatorSet?.start()

    }


}