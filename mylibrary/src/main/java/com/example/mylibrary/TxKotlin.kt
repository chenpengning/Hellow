package com.example.mylibrary

fun main() {

    val list = arrayListOf("12", "123", "1234")


    val max = list.maxBy {

        it.length
    }


    var labam = { str: String ->
        str.length

    }


    var meth: (str: String) -> Int

    val result = list.maxBy({ str: String ->
        str.length

    })
    val result1 = list.maxBy { str: String ->
        str.length

    }

    val result2 = list.maxBy {
        it.length

    }


    //println(kk("df"))


}

fun maxx(string: String): Int {

    return string.length

}


fun String.max() {

}