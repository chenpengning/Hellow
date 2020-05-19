package com.example.hellow

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.ViewGroup

class Flow1Layout : ViewGroup{

    //总的行数
    var arlistLines = ArrayList<List<View>>()
    //记录每行的高的集合
    var arheighs = ArrayList<Int>()
    //测量后总的高度
    var parentHeight = 0
    //测量后总的宽度
    var parentWidth = 0




    constructor(context: Context?) :super(context) {
        init()
        Log.d("d", "")

    }



    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init()
        Log.d("", "")
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ){init()}


    fun init(){
        arlistLines.clear()
        arheighs.clear()

    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        init()

        //ViewGroup解析的宽度
        var selfWidth = MeasureSpec.getSize(widthMeasureSpec)
        //ViewGroup解析的高度
        var selfHeight= MeasureSpec.getSize(heightMeasureSpec)

//        var paddleft = paddingLeft
//        var paddright = paddingRight
//        var paddtop = paddingTop
//        var paddbotton = paddingBottom


          var listview = ArrayList<View>()

          var  lineHight = 0

          var linewidthuse = 0

          var requeWidth = 0
          var requeHeight = 0


        //先度量子类

        for(i in 0 until childCount){

            var view = getChildAt(i)

            var lp = view.layoutParams

            var childMeasureSpecWidth = getChildMeasureSpec(widthMeasureSpec,paddingLeft+ paddingRight,lp.width)
            var childMeasureSpecheigth= getChildMeasureSpec(heightMeasureSpec,paddingTop+paddingBottom,lp.height)

            view.measure(childMeasureSpecWidth,childMeasureSpecheigth)

            //得到测量后的值
            var childMesauredWidth = view.measuredWidth
            var childMeasuredHeight = view.measuredHeight


            //获取子view的宽高
           // int childMesauredWidth = childView.getMeasuredWidth();
           // int childMeasuredHeight = childView.getMeasuredHeight();

            //通过宽度来判断是否需要换行，通过换行后的每行的行高来获取整个viewGroup的行高
            //如果需要换行

            if(linewidthuse + childMesauredWidth > selfWidth){

                arlistLines.add(listview)

                arheighs.add(lineHight)


                //需要记录下来已经测量总的宽高
                requeWidth = Math.max(linewidthuse,requeWidth)
                requeHeight +=lineHight


                listview = ArrayList<View>()

                //listview.clear()
                linewidthuse=0
                lineHight = 0



            }

            //
            listview.add(view)

            linewidthuse +=  childMesauredWidth + 10

            lineHight = Math.max(childMeasuredHeight,lineHight)


            //处理最后一行数据
            if (i == childCount -1) {
                arlistLines.add(listview)
                arheighs.add(lineHight)
               // parentNeededHeight = parentNeededHeight + lineHeight + mVerticalSpacing;
                // parentNeededWidth = Math.max(parentNeededWidth, lineWidthUsed + mHorizontalSpacing);
                requeWidth = Math.max(linewidthuse,requeWidth)
                requeHeight +=lineHight
            }



        }

        //在度量自己,确定自己是哪一种的模式
        var modeW = MeasureSpec.getMode(widthMeasureSpec)

        var modeH = MeasureSpec.getMode(heightMeasureSpec)
        //然后在确定测了的大小
        var mearsuredWide = if(modeW == MeasureSpec.EXACTLY) selfWidth else requeWidth
        var mearsuredHeight = if(modeH == MeasureSpec.EXACTLY)  selfHeight else requeHeight
        //确定自己的大小
        setMeasuredDimension(mearsuredWide,mearsuredHeight)








    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {

        var linsize = arlistLines.size
        var curL =paddingLeft
        var curT = paddingTop

        for (i in 0 until linsize){
            //每一行的view集合
            var lines = arlistLines.get(i)
            //每一行高
            var lineHeight = arheighs.get(i)

            lines.forEachIndexed { index, view ->

                var left = curL
                var top = curT
                var right = left + view.measuredWidth
                var botton = top + view.measuredHeight
                view.layout(left,top,right,botton)

                curL= right + 10

            }

            curL = paddingLeft

            curT += lineHeight + 10



        }


    }
}