package com.example.hellow.mvp.api

import com.example.hellow.mvp.netwok.bean.LoginBean
import com.example.hellow.mvp.netwok.Response
import retrofit2.http.POST
import rx.Observable

interface LoginApi {

    @POST("user/login")
    fun login(username:String,password:String): Observable<Response<LoginBean>>
}