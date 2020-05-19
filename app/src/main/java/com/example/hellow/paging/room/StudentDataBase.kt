package com.example.hellow.paging.room

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager


@Database(entities = [Student::class], version = 1, exportSchema = false)
abstract  class StudentDataBase :RoomDatabase(){

    abstract  fun  getStudentDao():StudentDao

    companion object {

        // For Singleton instantiation
        @Volatile private var instance: StudentDataBase? = null

        fun getInstance(context: Context): StudentDataBase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabasex(context).also { instance = it }
            }
        }

        private fun buildDatabasex(context: Context): StudentDataBase {
            return Room.databaseBuilder(context, StudentDataBase::class.java, DATABASE_NAME).build()
        }
    }








}