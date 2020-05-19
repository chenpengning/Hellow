package com.example.hellow.paging

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.hellow.paging.room.SIZE
import com.example.hellow.paging.room_conver.ConcerDataBase
import com.example.hellow.paging.room_conver.ConcertBean


/**
 * 数据的来源
 */
class ConcertViewModel :ViewModel() {



    var convertList = LivePagedListBuilder<Int,ConcertBean>(ConcertFactory(), SIZE).build()









    /*
    * private final LiveData<PagedList<Concert>> convertList;
    private DataSource<Integer, Concert> concertDataSource;

    public ConcertViewModel() {
        ConcertFactory concertFactory = new ConcertFactory();
        concertDataSource = concertFactory.create();
        convertList = new LivePagedListBuilder<>(concertFactory, 20).build();
    }

    public void invalidateDataSource() {
        concertDataSource.invalidate();
    }

    public LiveData<PagedList<Concert>> getConvertList() {
        return convertList;
    }
    * */










    


}