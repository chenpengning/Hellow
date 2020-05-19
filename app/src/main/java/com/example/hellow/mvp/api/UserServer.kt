package com.example.hellow.mvp.api

import retrofit2.http.POST
import rx.Observable

interface UserServer {

    @POST("/user/login")
    fun login(name:String,age:String):Observable <*>
}