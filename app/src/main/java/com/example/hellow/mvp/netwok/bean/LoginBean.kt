package com.example.hellow.mvp.netwok.bean




data class LoginBean (
    var admin:Boolean,
    var chapterTops:List<*>,
    var collectIds:List<*>,
    var email:String?,
    var id: Int,
    var password:String?,
    var token:String?,
    var type:Int,
    var username:String?
)

/*

{
    "data": {
        "admin": false,
        "chapterTops": [],
        "collectIds": [],
        "email": "",
        "icon": "",
        "id": 60788,
        "nickname": "wanwone123456",
        "password": "",
        "publicName": "wanwone123456",
        "token": "",
        "type": 0,
        "username": "wanwone123456"
    },
    "errorCode": 0,
    "errorMsg": ""
}
 */