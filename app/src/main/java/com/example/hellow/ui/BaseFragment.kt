package com.example.hellow.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hellow.R
import com.example.hellow.utils.LogUtil
import kotlinx.android.synthetic.main.fragment_viewpage.*

class BaseFragment :Fragment() {


    private lateinit var listdata:List<Fragment>
    private lateinit var listTitle:List<String>

    companion object{

        fun getInstance() = BaseFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        LogUtil.logd("====basefragment onCreateView")
        return inflater.inflate(R.layout.fragment_viewpage,container,false)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LogUtil.logd("====basefragment onCreate")

         listdata = arrayListOf(MsgFragment.getInstance(),NewsFragment.getInstance())
         listTitle = arrayListOf("消息","通知")



    }

    override fun onResume() {
        super.onResume()

        mViewpage.adapter = ExpendPageAdapter(parentFragmentManager).setAdapterData(listdata,listTitle)

        mTablyout.setupWithViewPager(mViewpage)

    }
}