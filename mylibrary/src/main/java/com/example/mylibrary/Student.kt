package com.example.mylibrary

class  Student() {

    var id = 5

    lateinit var name : String

     lateinit var age : String


    private var map = HashMap<String, String>()




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

    public fun playStudent() {

        println("我的名字刘德华，张学友")
        println("====id=$id")
        map["key"] = "key"
    }

}