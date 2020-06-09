package com.example.mylibrary

fun main() {

    val array = arrayOf(1, 2, 3, 4, 5, 6, 7)

    val start = 0
    val end = array.size - 1


    val mid = (end + start).ushr(1)

    println("====mid = $mid")

    val result = binarySearch(array, 6)

    println("====result = $result")

}

fun binarySearch(array: Array<Int>, value: Int): Int {

    var start = 0
    var end = array.size - 1

    var mid: Int

    repeat(array.count()) {

        //mid = (end + start) / 2
        mid = (end + start).ushr(1)

        when {
            value < array[mid] -> {

                end = mid - 1

            }
            value > array[mid] -> {
                start = mid + 1

            }
            else -> {

                return mid
            }
        }
    }


    return -1
}