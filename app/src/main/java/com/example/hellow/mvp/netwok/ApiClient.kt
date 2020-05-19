package com.example.hellow.mvp.netwok

import com.example.hellow.BuildConfig
import com.example.hellow.mvp.api.LoginApi
import com.example.hellow.mvp.api.UserServer
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient private constructor() {

    private lateinit var instance :ApiClient

    private object Holder{

        val INSTANCE = ApiClient()

    }

    companion object{

         val instance by lazy { Holder.INSTANCE }

    }


    fun createHttpClient():Retrofit{

        var okHttpClient = OkHttpClient().newBuilder().addInterceptor(HttpLoggingInterceptor().setLevel(

            if(BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE

        )).build()


        var retrafitClient = Retrofit.Builder().baseUrl("https://www.wanandroid.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .client(okHttpClient)
            .build()

        return retrafitClient

    }

    fun userApi():LoginApi{

        return createHttpClient().create(LoginApi::class.java)

    }








}