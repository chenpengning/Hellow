package com.example.hellow.view

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import com.example.hellow.R
import com.example.hellow.utils.DensityUtil
import com.example.hellow.utils.LogUtil

class MyViewGroup : ViewGroup {


    //定义左边的偏移量
    private  var offSet = 0

    private  lateinit var str :String

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs){
        init(context,attrs)


    }
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )


    private fun init(context: Context?, attrs: AttributeSet?){



        var array = context?.obtainStyledAttributes(attrs, R.styleable.MyViewGroup)

        offSet = array?.getInteger(R.styleable.MyViewGroup_offset,100) ?:0
        // 使用结束之后释放资源
        array?.recycle()


    }



    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {

        // 1、viewgoup开始测量自己的大小；
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        // 2、为每个子view计算测量限制信息
        var widthMode = MeasureSpec.getMode(widthMeasureSpec)
        var wideSize = MeasureSpec.getSize(widthMeasureSpec)

        var heightMode = MeasureSpec.getMode(heightMeasureSpec)
        var heightSize = MeasureSpec.getSize(heightMeasureSpec)

        //设置padding属性

        var pdleft = paddingLeft

        LogUtil.logd("===pdleft=${pdleft}")


        // 3、把上一步确定的限制信息，传递给每一个子view，然后子view开始measure自己的尺寸
        var count = childCount

        var parentWide = 0
        var parentHeigh = 0
        var offSetUser = 0

        for (i in 0 until count) {

            var child = getChildAt(i)
            var lp = child.layoutParams

            var widthMeasureSpec = getChildMeasureSpec(widthMeasureSpec, pdleft, lp.width)
            var heightMeasureSpec = getChildMeasureSpec(heightMeasureSpec, 0, lp.height)

            child.measure(widthMeasureSpec, heightMeasureSpec)


        }

        // 5、viewgroup根据自身的情况，计算自己的尺寸
        // 4、获取子view测量完成后的尺寸
        // 6、保存自身的尺寸——onlayout使用

        when (widthMode) {

            MeasureSpec.EXACTLY -> parentWide = wideSize

            MeasureSpec.UNSPECIFIED,MeasureSpec.AT_MOST -> {

                for (i in 0 until childCount){
                    var view = getChildAt(i)

                    offSetUser = offSet * i + view.measuredWidth
                    parentWide = Math.max(offSetUser,wideSize)
                }

            }
        }

        when (heightMode) {

            MeasureSpec.EXACTLY -> parentHeigh = heightSize

            MeasureSpec.UNSPECIFIED,MeasureSpec.AT_MOST -> {

                for (i in 0 until childCount){
                    var view = getChildAt(i)

                    parentHeigh += view.measuredHeight
                }


            }
        }

        LogUtil.logd("===parentHeigh=${parentHeigh}")


        setMeasuredDimension(parentWide, parentHeigh)



    }


    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {

        //1、遍历子view	2、确定自己的规则	3、摆放子view的位置

        var left = 0
        var top = 0
        var right = 0
        var bottom = 0

        for (i in 0 until childCount) {

            var view = getChildAt(i)
            left = offSet * i + paddingLeft

            right = view.measuredWidth + left

            bottom = view.measuredHeight + top

            view.layout(left, top, right, bottom)

            top = top + view.measuredHeight


        }


    }
}