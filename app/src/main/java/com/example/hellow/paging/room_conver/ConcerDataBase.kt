package com.example.hellow.paging.room_conver

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.hellow.App


@Database(entities = [ConcertBean::class],version = 1,exportSchema = false)
abstract class ConcerDataBase:RoomDatabase() {



    abstract fun getConverDao():ConcertDao


    companion object{

        @Volatile
        private  var dataBase: ConcerDataBase? = null

        fun getInstance():ConcerDataBase{

            return dataBase ?: synchronized(this){

                dataBase ?: getDataBase().also { dataBase = it }
            }
        }

        private fun getDataBase():ConcerDataBase{

            val database = Room.databaseBuilder(App.instance,ConcerDataBase::class.java,"con_database")
                .allowMainThreadQueries()
                .build()

            return database
        }

    }















}