package com.fly.fox.project.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.fly.fox.project.R
import com.fly.fox.project.databinding.FragmentMainBinding
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment() {


    lateinit var dataBinding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragmen

        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)

        return dataBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bt_qq_anim.setOnClickListener {

            findNavController().navigate(R.id.action_mainFragment_to_firstFragment)
        }

        bt_right_bar.setOnClickListener {

            findNavController().navigate(R.id.action_mainFragment_to_animaFragment)
        }
    }


}
