package com.example.hellow.paging.room

import com.example.hellow.paging.room_conver.DataResposity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun main() {


    println("1==${DataResposity.getInstance()}")
    println("2==${DataResposity.getInstance()}")



    println("6==${DataResposity.getInstance().let { 
        
        8 
        
        6
       
        it
    
    }}")


}

fun getView(){

    Thread{
        println("4==${DataResposity.getInstance()}")

        Thread.sleep(3000)

    }.start()
}