package com.example.mylibrary

class  Student() {

    var id = 0

    lateinit var name : String

     lateinit var age : String


    constructor(id:Int):this(){
        println("====id=$id")
    }

    constructor(id: Int,name:String):this(id){
        println("====id=$id ===name=$name")
    }

    constructor(id: Int,name: String,age:String):this(id,name){
        println("====id=$id ===name=$name====age=$age")

        this.name = name
    }

}