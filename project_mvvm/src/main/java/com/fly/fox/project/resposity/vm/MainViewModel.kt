package com.fly.fox.project.resposity.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.fly.fox.project.resposity.RoomResposity
import com.fly.fox.project.resposity.room.Person
import java.lang.StringBuilder


class MainViewModel : ViewModel() {

    fun getHttpData(){
        RoomResposity.getInstance().getHttpData()
    }

    fun quaryAll():LiveData<List<Person>>{
        return RoomResposity.getInstance().quaryAll().let {

            it

        }
    }

    fun quay(){
        RoomResposity.getInstance().quaryallll()
    }

    //var i = 1
    fun updataData(person:String){

       // i++
       // val builder =StringBuilder(person).append(i)


        RoomResposity.getInstance().updataData(Person(6,person,person))
    }

    fun delectAll(){
        RoomResposity.getInstance().delectAll()
    }









}