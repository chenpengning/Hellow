package com.example.hellow.paging

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.hellow.paging.room_conver.ConcertBean


//DataSource.Factory<Integer, Concert>
class ConcertFactory :DataSource.Factory<Int,ConcertBean>() {



    /*
    *
    * private MutableLiveData<ConcertDataSource> mSourceLiveData =
            new MutableLiveData<>();
    * */

    var mSourceLiveData = MutableLiveData<ConcertDataSource>()



    override fun create(): DataSource<Int, ConcertBean> {

//        ConcertDataSource concertDataSource = new ConcertDataSource();
//        mSourceLiveData.postValue(concertDataSource);

//        var concertDataSource = ConcertDataSource()
//        mSourceLiveData.postValue(concertDataSource)


        return ConcertDataSource()

    }
}