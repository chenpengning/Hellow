package com.flyfox.network

import androidx.lifecycle.LiveData
import com.flyfox.newsclient.net.bean.LoginRes
import com.flyfox.newsclient.net.bean.ResponWrap
import com.flyfox.newsclient.net.bean.request.LoginReq
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Api {

    /**
     * name:wanwone123456
     * pwd:123456
     */

    //https://www.wanandroid.com/user/login
    @POST("/user/login")
    @FormUrlEncoded
    fun login(@Field("username") name: String, @Field("password") pwd: String): Observable<ResponWrap<LoginRes>>

    @POST("/user/login")
    fun loginBody(@Body body: LoginReq): Observable<ResponWrap<LoginRes>>

    @POST("/user/login")
    fun loginTemp(@Body body: LoginReq): LiveData<ResponWrap<LoginRes>>

    @POST("/user/text")
    fun text(): Call<ResponWrap<LoginRes>>


}