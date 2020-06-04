package com.fly.fox.project.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.fly.fox.project.R
import com.fly.fox.project.view.RightDialog
import com.lzf.easyfloat.EasyFloat
import kotlinx.android.synthetic.main.fragment_anima.*

/**
 * A simple [Fragment] subclass.
 */
class AnimaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_anima, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mv_right_rl.setOnClickListener {


            RightDialog().show(parentFragmentManager, "fd")
        }

        bottom.setOnClickListener {

            EasyFloat.showAppFloat()
        }
    }


}
