package com.fly.fox.project.resposity

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.fly.fox.project.resposity.room.Person
import com.fly.fox.project.resposity.room.PersonDao
import com.fly.fox.project.resposity.room.PersonDataBase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RoomResposity private constructor() {


    private var dao: PersonDao


    init {

        dao = PersonDataBase.getIntance().getPersonDao()

    }

    companion object {
        fun getInstance() = SingletonHolder.instance
    }

    private object SingletonHolder {
        val instance = RoomResposity()
    }


//    fun insertData(person: Person) {
//
//        dao.insertData(person)
//    }
//
//    fun delectData(person: Person) {
//
//        dao.delectData(person)
//
//    }
//
//    fun delectAllData() {
//
//        dao.delectAllData()
//
//    }
//
    fun quaryAll(): LiveData<List<Person>> {

        return dao.quaryAll()

    }

    fun quaryallll(){
        dao.quaryAll11().forEach {

            Log.d("xxx","====${it.name} ==${it.tag}")
        }
    }
//
//    fun updataName (name :String){
//
//        dao.updateName(name)
//
//    }
//
//
//    fun updatadata(person: Person){
//        dao.updataData(person)
//    }




    fun getHttpData() {

        GlobalScope.launch {

            addData()
        }

    }

     suspend fun addData(){

        for (i in 0..50){

            dao.insertData(Person(i,"name$i","tag$i"))
        }


    }



    fun updataData(person: Person){

       // GlobalScope.launch {
            dao.updataData(person)
        //}

    }

    fun delectAll(){
        GlobalScope.launch {
            dao.delectAllData()
        }
    }














}