package com.example.hellow.paging.room

import androidx.paging.DataSource
import androidx.room.*

@Dao
interface StudentDao {
    @Insert
    suspend fun insertData(vararg student : Student)//可变参数表示法

    @Delete
    fun delectData(student:Student)

    @Query("delete from students_table")
    suspend fun delectAll()


    @Update
    fun updateData(student: Student)


    @Query("select * from students_table")
    suspend fun quaryAllData() : List<Student>

    @Query("select * from students_table where uid =:id")
    fun quaryById(id:Long) : Student

    @Query("select * from students_table where name =:name")
    fun quaryByName(name:String) : Student


//    @Query("select * from students_table order by uid ")
//    suspend fun quaryData() : DataSource.Factory<Int,Student>
}