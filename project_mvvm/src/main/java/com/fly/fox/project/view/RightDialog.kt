package com.fly.fox.project.view

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import androidx.fragment.app.DialogFragment
import com.example.comment.utils.ScreenUtils
import com.fly.fox.project.R
import kotlin.math.roundToInt


class RightDialog : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var window = dialog?.window
        //须要用android.R.id.content这个view
        val view = inflater.inflate(
            R.layout.fragment_dialog,
            window!!.findViewById(android.R.id.content), false
        )
        window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))//注意此处

        window.setGravity(Gravity.RIGHT)
        window.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
        window.setLayout(
            (ScreenUtils.getScreenWidth() * 0.6).roundToInt(),
            (ScreenUtils.getScreenHeight() * 0.7).roundToInt()
        )//这2行,和上面的同样,注意顺序就行;

        window.setWindowAnimations(R.style.BottomDialogAnimation)

        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}