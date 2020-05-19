package com.fly.fox.project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.fly.fox.project.resposity.ui.DataAdapter
import com.fly.fox.project.resposity.vm.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    lateinit var adapter: DataAdapter

    lateinit var vm: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

        vm.quaryAll().observe(this, Observer {
            Log.d("xxx","observe data change.....")
            adapter.setData(it)
            adapter.notifyDataSetChanged()


        })


        countbutton.setOnClickListener {

            Log.d("xxxx","=====countbutton onclick ....")
        }

    }





    private fun init() {
        adapter = DataAdapter()
        recycleview.adapter = adapter
        adapter.setData(arrayListOf())
        recycleview.layoutManager = LinearLayoutManager(this)
        vm = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(MainViewModel::class.java)
    }

    fun onclickView(view: View) {

        when (view.id) {

            R.id.bt_insert -> {
                vm.getHttpData()

            }

            R.id.bt_quary -> {
               // vm.quaryAll()

                vm.quay()
            }

            R.id.bt_updata -> {

                var name = et_name.text.toString()

                vm.updataData(name)


            }

            R.id.bt_delect -> {
                vm.delectAll()
            }

        }


    }


}
