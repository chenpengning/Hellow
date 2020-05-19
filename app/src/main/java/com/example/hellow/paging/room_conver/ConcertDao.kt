package com.example.hellow.paging.room_conver

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ConcertDao {

    @Insert
    fun insertData(vararg concertBean: ConcertBean)//可变参数表示法

    @Query("delete from conver_table")
    fun delectAll()

    @Query("select * from conver_table order by id ")
    fun quaryData() : DataSource.Factory<Int, ConcertBean>

    @Query("select * from conver_table")
    fun quaryAllData() : List<ConcertBean>

}