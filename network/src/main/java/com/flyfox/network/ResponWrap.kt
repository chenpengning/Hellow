package com.flyfox.newsclient.net.bean

data class ResponWrap<T>(
    var data: T?,
    val errorCode: Int,
    val errorMsg: String
)

/**
{
"data": null,
"errorCode": 0,
"errorMsg": ""
}
 *
 */