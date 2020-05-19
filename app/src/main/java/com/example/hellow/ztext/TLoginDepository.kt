package com.example.hellow.ztext

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData


/**
 * 保证仓库对象的唯一性，因为项目中可能多次使用仓库对象，
 * 封装model层调用的业务的方法，设计为单例模式
 *
 * 静态内部类的写法
 */
class TLoginDepository private constructor() {


    companion object {

        /**
         * 对外暴露的访问方法
         */
        fun getInstance(): TLoginDepository {
            return SingletonHolder.instance
        }

        private object SingletonHolder {
            val instance = TLoginDepository()
        }

    }


    /**
     * 具体去实现登陆的业务逻辑
     */
    fun loggin(loginLiveData: MutableLiveData<List<LoginBean>>, name: String, pwd: String) {

        var list = ArrayList<LoginBean>()

        fun getlognData():List<LoginBean> {

            for (i in 0..200) {
                list.add(LoginBean("jetpack+ ${i}", "123+${i}"))

            }

            return list

        }

//        Thread {
//            //网络请求的方法
//            Thread.sleep(20000)
//            loginLiveData.value = getlognData()
//
//        }.start()


    }


}