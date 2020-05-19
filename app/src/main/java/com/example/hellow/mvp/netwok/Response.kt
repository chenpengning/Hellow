package com.example.hellow.mvp.netwok


/*
{
    "data": null,
    "errorCode": -1,
    "errorMsg": "用户名已经被注册！"
}
 */
data class  Response<T>(

    var data: T,
    var errorCode :Int,
    var errorMsg:String

)