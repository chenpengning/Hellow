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


    val ç = { a: Int ->
        println("===$a")

        a + 5
    }

    var m02: (Int) -> Int = { a: Int ->
        println("===$a")

        a + 5
    }

    println("==01=${m02(8)}")

    //println(kk("df"))

    m03(50) {
        50
        60
        it + 100
    }

}

fun m03(num: Int, m02: (Int) -> Int) {

    println("===m03 result=${num.plus(m02(num))}")


}

fun maxx(string: String): Int {

    return string.length

}


fun String.max() {

}