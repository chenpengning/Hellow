package com.example.hellow.navigation

import android.os.Bundle
import android.view.*
import androidx.fragment.app.DialogFragment
import android.graphics.drawable.ColorDrawable
import android.view.ViewGroup
import android.graphics.Color
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import com.example.hellow.R
import com.example.hellow.navigation.ui.MyViewPagerAdapter
import com.example.hellow.navigation.ui.News1Fragment
import com.example.hellow.navigation.ui.NewsFragment
import kotlinx.android.synthetic.main.fragment_bottom_dialog.*


class BotomDialog :DialogFragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var window = dialog?.window
        //须要用android.R.id.content这个view
        val view = inflater.inflate(R.layout.fragment_bottom_dialog,
            window!!.findViewById(android.R.id.content), false)
        window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))//注意此处

        window.setGravity(Gravity.BOTTOM)
        window.setLayout(MATCH_PARENT,WRAP_CONTENT)//这2行,和上面的同样,注意顺序就行;

        window.setWindowAnimations(R.style.BottomDialogAnimation)

        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var lists = arrayListOf(NewsFragment(), News1Fragment())

        var tital = arrayListOf("消息","消息")
        msg_vp.adapter = MyViewPagerAdapter(childFragmentManager,lists,tital)

        msg_tab.setupWithViewPager(msg_vp)
    }
}