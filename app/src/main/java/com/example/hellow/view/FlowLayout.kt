package com.example.hellow.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup

class FlowLayout :ViewGroup{


    //所有的行高
    private var lineHeights = ArrayList<Int>()
    //所有的行数
    private var lines = ArrayList<ArrayList<View>>()


    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)


    private fun init(){

        lines.clear()
        lineHeights.clear()
        //lineViews.clear()


    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        init()
        // 2、为每个子view计算测量限制信息
        var widthMode = MeasureSpec.getMode(widthMeasureSpec)
        var wideSize = MeasureSpec.getSize(widthMeasureSpec)

        var heightMode = MeasureSpec.getMode(heightMeasureSpec)
        var heightSize = MeasureSpec.getSize(heightMeasureSpec)

        var lineHeight = 0
        var lineUsedWide = 0
        var totalHeight = 0 //测量viewgroup 高度
        var parentWide = 0 //测量viewgroup 宽度

        //一行所有的view
        var lineViews = ArrayList<View>()

        for(i in 0 until childCount){

            var child = getChildAt(i)

            measureChild(child,widthMeasureSpec,heightMeasureSpec)


            if(lineUsedWide + child.measuredWidth > wideSize){

                lines.add(lineViews)

                lineHeights.add(lineHeight)

                totalHeight += lineHeight

                parentWide = Math.max(lineUsedWide,parentWide)


                //换行重置数值
                lineHeight = 0
                lineUsedWide = 0
                lineViews = ArrayList<View>()

            }

            lineViews.add(child)
            //计算每一行的宽高
            lineUsedWide += child.measuredWidth
            lineHeight = Math.max(lineHeight,child.measuredHeight)

            //处理最后一行数据
            if(i == childCount -1){

                lines.add(lineViews)

                lineHeights.add(lineHeight)

                totalHeight += lineHeight

                parentWide = Math.max(lineUsedWide,parentWide)

            }

        }


        //测量viewgroup的大小

        setMeasuredDimension(if(widthMode == MeasureSpec.EXACTLY) wideSize else parentWide,

            if (heightMode == MeasureSpec.EXACTLY) heightSize else totalHeight )


    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {

        //高度为累加值，不能重置
        var curY = 0

        lines.forEachIndexed { i, childViews ->

            var lineHeight = lineHeights[i]

            var curX = 0

            childViews.forEachIndexed { index, view ->

                var left = curX
                var top = curY
                var right = view.measuredWidth + left
                var bottom = view.measuredHeight + top

                view.layout(left,top,right,bottom)

                curX = left+view.measuredWidth

            }

            curY += lineHeight

        }


    }
}