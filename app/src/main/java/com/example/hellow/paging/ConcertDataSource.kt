package com.example.hellow.paging

import androidx.paging.PositionalDataSource
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import com.example.hellow.paging.Concert
import android.icu.lang.UCharacter.GraphemeClusterBreak.V
import com.example.hellow.paging.ConcertDataSource
import com.example.hellow.paging.room.SIZE
import com.example.hellow.paging.room_conver.ConcertBean


/*
* PositionalDataSource
*
* */
class ConcertDataSource :PositionalDataSource<ConcertBean>() {





    //当有了初始化数据之后，滑动的时候如果需要加载数据的话，会调用此方法。
    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<ConcertBean>) {

        callback.onResult(getConcertList(params.startPosition,params.loadSize))

    }

    //加载初始化数据，可以这么来理解，加载的是第一页的数据。形象的说，当我们第一次打开页面，需要回调此方法来获取数据。
    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<ConcertBean>) {

        callback.onResult(getConcertList(0, SIZE),0,100)

    }


    fun getConcertList(start :Int, size :Int):List<ConcertBean>{

        var list  = ArrayList<ConcertBean>()

        for (i in start until  (size+start) ){

            list.add(ConcertBean(i,"name=${i}"))

        }

        return list


    }
}