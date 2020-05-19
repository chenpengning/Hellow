package com.example.hellow.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.hellow.R
import kotlinx.coroutines.*

class KontlinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kontlin)


        runBlocking {
            fetchDocs()
        }


        var map = HashMap<String,String>()
        map.put("s","s")



        //LayoutInflater.from(this).inflate(0,root,false)

        GlobalScope.launch { // 在后台启动一个新的协程并继续
            delay(1000L) // 非阻塞的等待 1 秒钟（默认时间单位是毫秒）
            println("World!") // 在延迟后打印输出
        }
        println("Hello,") // 协程已在等待时主线程还在继续
        Thread.sleep(2000L) // 阻塞主线程 2 秒钟来保证 JVM 存活



}


    //kontlin 协程用法
    private fun association(){
        //开启线程用法
        Thread{

        }.start()




    }

//    fun onDocsNeeded() {
//        viewModelScope.launch {    // Dispatchers.Main
//            fetchDocs()            // Dispatchers.Main (suspend function call)
//        }
//    }


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

}
