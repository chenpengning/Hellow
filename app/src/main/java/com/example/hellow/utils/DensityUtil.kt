package com.example.hellow.utils

import android.content.Context

 class DensityUtil {

     companion object{


         /**
          * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
          */
         fun dip2px(context: Context, dpValue: Float): Int {
             val scale = context.getResources().getDisplayMetrics().density
             return (dpValue * scale + 0.5f).toInt()
         }

         /**
          * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
          */
         fun px2dip(context: Context, pxValue: Float): Int {
             val scale = context.getResources().getDisplayMetrics().density
             return (pxValue / scale + 0.5f).toInt()
         }

     }
}