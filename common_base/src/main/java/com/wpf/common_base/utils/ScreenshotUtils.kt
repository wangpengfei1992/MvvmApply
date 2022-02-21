package com.wpf.common_base.utils

import android.graphics.Bitmap
import android.graphics.Canvas
import android.widget.ScrollView

/**
 *  Author: feipeng.wang
 *  Time:   2022/2/21
 *  Description : 截图工具类
 */
class ScreenshotUtils {
    fun getScrollScreenShot(view: ScrollView?): Bitmap? {
        if (null != view) {
            var height = 0
            //正确获取ScrollView
            for (i in 0 until view.getChildCount()) {
                height += view.getChildAt(i).getHeight()
            }
            if (height > 0) {
                //创建保存缓存的bitmap
                val bitmap = Bitmap.createBitmap(view.getWidth(), height, Bitmap.Config.RGB_565)
                //可以简单的把Canvas理解为一个画板 而bitmap就是块画布
                val canvas = Canvas(bitmap)
                //把view的内容都画到指定的画板Canvas上
                view.draw(canvas)
                return bitmap
            }
        }
        return null
    }
}