package com.example.mylibrary

fun main() {


    var student1 = Student(20)

    println("student id $student1.id")


    var mSclass1 = Class.forName("com.example.mylibrary.Student")

    var mSclass = Student::class.java


    var student = mSclass.newInstance()


    var method = mSclass.getDeclaredMethod("playStudent")

    method.invoke(student)

    var id = mSclass.getDeclaredField("id")

    id.isAccessible = true
    id.set(student, 20)

    method.invoke(student)


    var map = mSclass.getDeclaredField("map")
    map.isAccessible = true


}


