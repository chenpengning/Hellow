package com.example.hellow.kotlin

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.fragment.app.Fragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.math.BigInteger

class LoginFragment :Fragment() {

    private lateinit var name : EditText

    private var defult = "8978"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d(TAG,"")

        //Elvis 表达式 ?:
        var namevalue = defult?.trim() ?:"df"
        //另一种用法
        namevalue ?: return



        //if语法
        var age = if (namevalue == "1") {
            "df"
        }else{
            "dfdf"
        }

        //第一种使用lamba表达式
         var les = stringMapper("Android", { input ->
            input.length
        })

        //第二种使用匿名函数
        var less = stringMapper("android"){

            it.length

        }

        var dis = display0("android"){
            Log.d(TAG,"---android")
        }


        Log.d(TAG,"---les=${less}")


        //
       Log.d(TAG,"stringLengthFunc=${stringLengthFunc("android")}")


//        launch(Dispatchers.IO) {
//
//        }





    }


    //协程的使用
    suspend fun fetchDocs() {                             // Dispatchers.Main
        val result = getEx("https://developer.android.com") // Dispatchers.IO for `get`
        //show(result)                                      // Dispatchers.Main
    }

    suspend fun getEx(url: String){

        withContext(Dispatchers.IO){

        }



    }

    suspend fun get(url: String) = withContext(Dispatchers.IO) { /* ... */ }

    //匿名函数实例
   val stringLengthFunc: (String) -> Int = { input ->
        input.length
    }


    //高级函数实例
    private fun stringMapper(str: String, mapper: (String) -> Int): Int {
        // Invoke function
        return mapper(str)
    }

    private fun display0(str:String,add:() -> Unit):Int{
        add()
        return str.length
    }










    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    //伴生语法
    companion object {

        private const val TAG = "***"

        @JvmField val BIG_INTEGER_ONE = BigInteger.ONE

         val age = 9


        //伴生函数标准写法
        @JvmStatic fun doWork() {
            /* … */
        }

    }
}