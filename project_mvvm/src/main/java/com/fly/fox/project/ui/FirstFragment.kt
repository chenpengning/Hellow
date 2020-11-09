package com.fly.fox.project.ui


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.fly.fox.project.R
import com.fly.fox.project.databus.LiveDataBus
import com.lzf.easyfloat.EasyFloat
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.ObservableOnSubscribe
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Function
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
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
        initData()
        RxJavaText()

//        LiveDataBus.instance.with("fox", String::class.java).observe(FirstFragment@ this, Observer {
//
//            Log.d("xxxx", "=====after nama = $it")
//
//        })

    }

    private fun initData() {
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
            LiveDataBus.instance.with("fox", String::class.java).value = "end"

            EasyFloat.hideAppFloat()
        }
    }


    private fun RxJavaText() {


        RxJavaPlugins.setOnObservableAssembly(object : Function<Observable<Any>, Observable<Any>> {
            override fun apply(t: Observable<Any>): Observable<Any> {


                Log.d("====", "=====拦截的obserable ：${t}")
                return t
            }

        })




        Observable.create(object : ObservableOnSubscribe<String> {
            override fun subscribe(emitter: ObservableEmitter<String>) {
                emitter.onNext("1")
            }
        })

//            .flatMap {
//
//                Observable.just(it)
//            }

//
//            .doOnNext(object :Consumer<String>{
//                override fun accept(t: String?) {
//                    Log.d("====","=====doOnNext obserable ：${t}")
//                }
//
//            })

            //ObservableCreate.map
            .map(Function<String, Boolean> {
                Log.d("====", "=====doOnNext obserable ：${it}")
                false
            })
            //ObservableMap.subscribe
            .observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<Boolean> {
                override fun onComplete() {
                }

                override fun onSubscribe(d: Disposable) {
                }

                override fun onNext(t: Boolean) {
                }

                override fun onError(e: Throwable) {
                }

            })
    }

}
