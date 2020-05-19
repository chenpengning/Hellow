package com.example.hellow.paging

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.view.View
import androidx.lifecycle.Observer
import androidx.paging.LivePagedListBuilder
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hellow.R
import com.example.hellow.paging.room.*
import com.example.hellow.paging.room_conver.ConcerDataBase
import com.example.hellow.paging.room_conver.ConcertBean
import com.example.hellow.paging.room_conver.ConcertDao
import com.example.hellow.paging.room_conver.DataResposity
import com.example.hellow.utils.LogUtil
import kotlinx.android.synthetic.main.activity_my_paging.*

class MyPagingActivity : AppCompatActivity() {


    //private lateinit var studentDao: StudentDao

    private lateinit var viewModel: ConcertViewModel

    private lateinit var  concertDao: ConcertDao

    var adapter = ExpendConvertAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_paging)
      //  studentDao = StudentDataBase.getInstance(this).getStudentDao()

        concertDao = ConcerDataBase.getInstance().getConverDao()



//        concertDao.delectAll()

//        viewModel = ViewModelProvider(
//            this,
//            ViewModelProvider.NewInstanceFactory()
//        ).get(ConcertViewModel::class.java)


          pg_recycleview.adapter = adapter
//
          pg_recycleview.layoutManager  = LinearLayoutManager(this)



        var data = LivePagedListBuilder(concertDao.quaryData(), SIZE).build().observe(this, Observer {


            adapter.submitList(it)

        })


//        viewModel.convertList.observe(this, Observer {
//
//            adapter.submitList(it)
//
//        })





    }


    var hander = object : Handler() {

        override fun dispatchMessage(msg: Message?) {
            super.dispatchMessage(msg)


        }

    }


    private fun insert() {
       // studentDao.insertData(Student(0, "zhou", "12"))

    }


    fun onpagingLisenter(view: View) {


        when (view.id) {

            R.id.insert -> {

                DataResposity.getInstance().getConcertData(concertDao)

//                Thread {
//
//                    insert()
//
//                }.start()

            }

            R.id.quary -> {

                DataResposity.getInstance().quaryAll(concertDao)

//                var student: List<Student>
//                Thread {
//
//                    student = studentDao.quaryAllData()
//
//                    student.forEach {
//
//                        LogUtil.logd("student name = ${it.name}")
//                    }
//
//                }.start()


            }

            R.id.delect ->{
                DataResposity.getInstance().delectData(concertDao)


            }




        }

    }


}
