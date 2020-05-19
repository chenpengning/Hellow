package com.example.hellow.navigation.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class MyViewPagerAdapter(fm: FragmentManager, list: List<Fragment>,titals:List<String>) :
    FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    var lists :MutableList<Fragment>

    var tital :MutableList<String>

    init {
        lists = ArrayList()
        lists.addAll(list)
        tital = ArrayList()
        tital.addAll(titals)


    }

    override fun getItem(position: Int): Fragment {
        return lists[position]
    }

    override fun getCount(): Int {

       return  lists.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return tital[position]
    }


}