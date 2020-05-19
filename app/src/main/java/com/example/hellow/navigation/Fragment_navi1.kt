package com.example.hellow.navigation


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.hellow.R
import kotlinx.android.synthetic.main.fragment_fragment_navi1.*

/**
 * A simple [Fragment] subclass.
 */
class Fragment_navi1 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_navi1, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        bt_navi1.setOnClickListener {

//            var a =
//                Fragment_navi1Directions.actionFragmentNavi1ToNavi3Fragment(
//                    "liudehua",
//                    23
//                )
//
//            it.findNavController().navigate(a)

            BotomDialog().show(parentFragmentManager,"df")

        }

        bt_navi2.setOnClickListener {
            BotomDialog().show(parentFragmentManager,"df")
        }
    }

}
