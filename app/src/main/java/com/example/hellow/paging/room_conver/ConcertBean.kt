package com.example.hellow.paging.room_conver

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "conver_table")
data class ConcertBean(
    @PrimaryKey
    var id: Int,
    @ColumnInfo
    var name: String
)