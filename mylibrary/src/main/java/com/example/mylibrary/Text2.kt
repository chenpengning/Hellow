package com.example.mylibrary

import android.util.Log

fun main() {

    var t = Text2("fly fox")
    println("name = ${t.name}")
    t.name = "jet pack"
    println("name = ${t.name}")

   // println(Student())
    var student = Student(5,"fox","45")
    println("${student.name}")


    var a = A("dfdf")

    println("===${a.value}")



}

 class Text2(name:String) {

    private var namex = name
     var name
    set(value) {
        namex = value
    }
    get() = namex

}

open class B{}
class C:B(){}


/**
 * 泛型类的声明
 */
open class A<T>(t:T){

    var value = t
}


/**
 * 泛型的方法声明
 */
fun <T> copy(des:ArrayList<T> ,src:ArrayList<T>){

    src.forEachIndexed { index, value ->

        des[index] = src[index]
    }
}

/**
 * 泛型的接口声明
 */
interface Source<T>{

    fun get():T
}

