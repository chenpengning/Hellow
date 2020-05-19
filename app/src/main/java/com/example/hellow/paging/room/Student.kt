package com.example.hellow.paging.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "students_table")
data class Student(
 @PrimaryKey val uid: Int,
 @ColumnInfo val name: String?,
 @ColumnInfo val age: String?

)


//@Entity(tableName = "students_table")
//data class Student(
// @PrimaryKey @ColumnInfo(name = "id")
// val id: String,
//// @ColumnInfo(name = "name")
// val name: String,
//// @ColumnInfo(name = "age")
// val age:String
//
//)
