package com.example.hellow.paging.room_conver

import com.example.hellow.paging.room.Student
import com.example.hellow.paging.room.StudentDao
import com.example.hellow.utils.LogUtil
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DataResposity private constructor() {

    companion object{

        fun getInstance() =
            SingletonHolder.INSTANCE
    }

    private object SingletonHolder{

         val INSTANCE = DataResposity()
    }




    fun getConcertData(dao: ConcertDao){


        GlobalScope.launch {
            LogUtil.logd("====协程开始执行")

            insertData(dao)

            LogUtil.logd("====协程已经执行完")
        }


    }


    fun quaryAll(dao: ConcertDao){

        GlobalScope.launch {

            dao.quaryAllData().forEach {

                LogUtil.logd("===name=${it.name}")
            }
        }

    }


    fun delectData(dao: ConcertDao){
        GlobalScope.launch {
            LogUtil.logd("====协程开始执行删除")

            delect(dao)

            LogUtil.logd("====协程已经执行删除完")
        }


    }



    private  fun delect(dao: ConcertDao){

        dao.delectAll()


    }

    private  fun insertData(dao: ConcertDao){

        for (i in 0..100){

            dao.insertData(ConcertBean(i,"name=$i"))
        }

    }




}