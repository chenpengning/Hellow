package com.example.mylibrary

import kotlin.concurrent.thread

//class Text1 {


    var list = arrayListOf<String>()

    var list1 = emptyList<String>()

    fun main(){

        list.add("666")

        list.forEach {

            println(it)
        }

        var mGroupFlags = 0x200110

        var FLAG_SPLIT_MOTION_EVENTS = 0x211101

        var split = mGroupFlags and FLAG_SPLIT_MOTION_EVENTS != 0

        var split1 = (5 or 12) != 0

        println(split1)


        println(0x80)






    }



    //协程的实例
    fun lacher(){





        //
        thread {




        }.start()

        println("h")

    }





//}