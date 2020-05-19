package com.fly.fox.project.resposity.room

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*

@Dao
interface PersonDao {

    @Insert
    fun insertData(person: Person)

    @Update
    fun updataData(person: Person)

    @Delete
    fun delectData(person: Person)

    @Query(value = "delete from person_table")
    fun delectAllData()


    @Query(value = "select * from person_table Order by uid")
    fun quaryAll(): LiveData<List<Person>>


    @Query(value = "select * from person_table Order by uid")
    fun quaryAll11(): List<Person>


}