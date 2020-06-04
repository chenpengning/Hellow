package com.fly.fox.project.ui


import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.fly.fox.project.R
import com.lzf.easyfloat.EasyFloat
import com.lzf.easyfloat.enums.ShowPattern
import com.lzf.easyfloat.enums.SidePattern
import com.lzf.easyfloat.interfaces.OnInvokeView
import kotlinx.android.synthetic.main.fragment_floatview.*

/**
 * A simple [Fragment] subclass.
 */
class FloatViewFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_floatview, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        float_View.setOnClickListener {

            var view = LayoutInflater.from(context).inflate(R.layout.window_floatview, null, false)


            startFloatWindow()

        }

    }

    private fun startFloatWindow() {

        EasyFloat.with(requireContext())
            // 设置浮窗xml布局文件，并可设置详细信息
            .setLayout(R.layout.window_floatview, OnInvokeView {


            })
            // 设置浮窗显示类型，默认只在当前Activity显示，可选一直显示、仅前台显示、仅后台显示
            .setShowPattern(ShowPattern.ALL_TIME)
            // 设置吸附方式，共15种模式，详情参考SidePattern
            .setSidePattern(SidePattern.RESULT_HORIZONTAL)
            // 设置浮窗的标签，用于区分多个浮窗
            //.setTag("testFloat")
            // 设置浮窗是否可拖拽，默认可拖拽
            .setDragEnable(true)
            // 系统浮窗是否包含EditText，仅针对系统浮窗，默认不包含
            // .hasEditText(false)
            // 设置浮窗固定坐标，ps：设置固定坐标，Gravity属性和offset属性将无效
            .setLocation(100, 200)
            // 设置浮窗的对齐方式和坐标偏移量
            .setGravity(Gravity.END or Gravity.CENTER_VERTICAL, 0, 200)
            // 设置宽高是否充满父布局，直接在xml设置match_parent属性无效
            // .setMatchParent(widthMatch = false, heightMatch = false)
            // 设置Activity浮窗的出入动画，可自定义，实现相应接口即可（策略模式），无需动画直接设置为null
            // .setAnimator(DefaultAnimator())
            // 设置系统浮窗的出入动画，使用同上
            //.setAppFloatAnimator(AppFloatDefaultAnimator())
            // 设置系统浮窗的不需要显示的页面
            // .setFilter(MainActivity::class.java, SecondActivity::class.java)
            // 设置系统浮窗的有效显示高度（不包含虚拟导航栏的高度），基本用不到，除非有虚拟导航栏适配问题
            //.setDisplayHeight(OnDisplayHeight { context -> DisplayUtils.rejectedNavHeight(context) })
            // 浮窗的一些状态回调，如：创建结果、显示、隐藏、销毁、touchEvent、拖拽过程、拖拽结束。
            // ps：通过Kotlin DSL实现的回调，可以按需复写方法，用到哪个写哪个
            .registerCallback {
                createResult { isCreated, msg, view -> }
                show { }
                hide { }
                dismiss { }
                touchEvent { view, motionEvent -> }
                drag { view, motionEvent -> }
                dragEnd { }
            }
            // 创建浮窗（这是关键哦😂）
            .show()

    }


}
