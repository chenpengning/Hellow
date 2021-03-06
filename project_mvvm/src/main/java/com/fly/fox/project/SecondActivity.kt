package com.fly.fox.project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fly.fox.project.event.SaveEvent
import kotlinx.android.synthetic.main.activity_second.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class SecondActivity:AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        EventBus.getDefault().register(this)



        button1.setOnClickListener {

            text1.text = ed1.text.toString()

            text2.text = ed2.text.toString()

            mAnim.startAnim()

            lottieAnim.playAnimation()
            //living()
        }

        button2.setOnClickListener {

            // animatorSet.cancel()
            lottieAnim.cancelAnimation()
            mAnim.cancelAnim()


            EventBus.getDefault().post(SaveEvent())

        }


    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun message(event: SaveEvent) {

    }

//    var  animatorSet = AnimatorSet()
//    private fun living(){
//
//        var listAnis = ArrayList<Animator>()
//
//        var an = ObjectAnimator.ofFloat(tv1, "scaleY", 1f, 2f, 1f)
//        an.repeatCount = ValueAnimator.INFINITE
//        an.start()
//        listAnis.add(an)
//
//        var an2 = ObjectAnimator.ofFloat(tv2, "scaleY", 1f, 2f, 1f)
//        an2.repeatCount = ValueAnimator.INFINITE
//        an2.startDelay = 200
//        an2.start()
//        listAnis.add(an2)
//
//        var an3 = ObjectAnimator.ofFloat(tv3, "scaleY", 1f, 2f, 1f)
//        an3.repeatCount = ValueAnimator.INFINITE
//        an3.startDelay = 500
//        an3.start()
//        listAnis.add(an3)
//
//
//        animatorSet.playTogether(listAnis)
//        animatorSet.start()
//
//
//    }
}