package com.fly.fox.project.resposity.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.fly.fox.project.App

@Database(entities = [Person::class],version = 2,exportSchema = false)
abstract class PersonDataBase :RoomDatabase(){

    abstract fun getPersonDao() :PersonDao


    companion object{

        @Volatile
        private  var instance :PersonDataBase? = null

        fun getIntance() = instance ?: synchronized(this){
            instance ?: getDataBase().let {it}
        }

        private fun getDataBase():PersonDataBase {

            return Room.databaseBuilder(App.instance,PersonDataBase::class.java,"person_db")
                .allowMainThreadQueries()
                .addMigrations(MIGRATION_1_2)
                .build()
        }

        var MIGRATION_1_2  = object : Migration(1,2){

            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL(
                    "ALTER TABLE person_table ADD COLUMN tag TEXT NOT NULL DEFAULT ''")

            }

        }


    }








}