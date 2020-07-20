package com.fly.fox.project.resposity

import androidx.lifecycle.MutableLiveData
import com.flyfox.network.Api
import com.flyfox.newsclient.net.bean.LoginRes
import com.flyfox.newsclient.net.bean.ResponWrap
import com.flyfox.newsclient.net.bean.request.LoginReq
import com.iwith.data.net.RetrofitFactory
import io.reactivex.Observable

class NetWorkResposity private constructor() {


    companion object {

        val instance: NetWorkResposity by lazy(LazyThreadSafetyMode.SYNCHRONIZED) { NetWorkResposity() }
    }

    fun login(name: String, pwd: String, data: MutableLiveData<ResponWrap<LoginRes>>) {

        val response =
            RetrofitFactory.instance.create(Api::class.java).loginTemp(LoginReq(name, pwd)).value

        data.value = response


    }


    fun loginbody(name: String, pwd: String): Observable<ResponWrap<LoginRes>> {

        return RetrofitFactory.instance.create(Api::class.java).loginBody(LoginReq(name, pwd))
    }


}