package com.example.hellow.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.hellow.R

class ExpendPageAdapter(fm:FragmentManager) :FragmentPagerAdapter(fm,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
//BEHAVIOR_SET_USER_VISIBLE_HINT
//BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT

    private lateinit  var listData :List<Fragment>
    private lateinit var listTitle:List<String>

    /**
     * tab页面/banner
     */
    fun setAdapterData(data :List<Fragment>,tabTitle:List<String>) :ExpendPageAdapter{
        listData = data
        listTitle = tabTitle
        //this.context = context
        return this

    }

    /**
     * 扩展保留方法
     */
    fun setAdapterData(data :List<Fragment>) :ExpendPageAdapter{
        listData = data
        return this

    }



    override fun getItem(position: Int): Fragment {
        return listData.get(position)
    }

    override fun getCount(): Int {
        return listData.size
    }

    override fun getPageTitle(position: Int): String {
        return listTitle[position]
    }











}