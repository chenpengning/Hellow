package com.fly.fox.project.resposity

import androidx.lifecycle.MutableLiveData
import applySchedulersOnSingle
import com.flyfox.network.Api
import com.flyfox.newsclient.net.bean.LoginRes
import com.flyfox.newsclient.net.bean.ResponWrap
import com.flyfox.newsclient.net.bean.request.LoginReq
import com.iwith.data.net.RetrofitFactory
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class NetWorkResposity private constructor() {


    companion object {

        val instance: NetWorkResposity by lazy(LazyThreadSafetyMode.SYNCHRONIZED) { NetWorkResposity() }
    }

    fun login(name: String, pwd: String, data: MutableLiveData<ResponWrap<LoginRes>>) {

        val response =
            RetrofitFactory.instance.create(Api::class.java).loginTemp(LoginReq(name, pwd)).value

        data.value = response


    }


    fun loginbody(name: String, pwd: String) {

        RetrofitFactory.instance.create(Api::class.java).loginBody1(LoginReq(name, pwd))
            .subscribeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe {


            }



    }


    fun loginBody1(name: String, pwd: String): Single<ResponWrap<LoginRes>> {

        return RetrofitFactory.instance.create(Api::class.java).loginBody(LoginReq(name, pwd))
            .compose(applySchedulersOnSingle())

    }


}