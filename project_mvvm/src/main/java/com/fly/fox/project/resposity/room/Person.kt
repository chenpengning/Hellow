package com.fly.fox.project.resposity.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "person_table")
data class Person(
    @PrimaryKey
    var uid:Int,
    @ColumnInfo(name = "name")
    var name:String,
    @ColumnInfo(name = "tag")
    var tag:String

)
//class Person(uid: Int, name: String,tag:String ) {
//    @PrimaryKey(autoGenerate = true)
//    var uid: Int = 0
//        set(value) {
//            field = value
//        }
//        get() = field
//
//    @ColumnInfo(name = "name")
//    var name: String = ""
//        set(value) {
//            field = value
//        }
//        get() = field
//    @ColumnInfo(name = "tag")
//    var tag: String = ""
//        set(value) {
//            field = value
//        }
//        get() = field
//}

