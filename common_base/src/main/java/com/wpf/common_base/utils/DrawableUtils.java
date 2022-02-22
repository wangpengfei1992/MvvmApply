package com.wpf.common_base.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/**
 * Author: feipeng.wang
 * Time:   2022/2/22
 * Description : 图片相关
 */
public class DrawableUtils {
    /**
     * 变换资源图片的大小
     * @param drawable 将要变换的图片，可以是ID资源，此处使用drawable
     * @param w 目标图片宽
     * @param h 目标图片高
     * @return Drawable
     */
    public static Drawable zoomDrawable(Drawable drawable, int w, int h) {
        //如果传入的是ID资源，启动此行代码,要传入当前上下文哦
        //Drawable drawable = context.getResources().getDrawable(R.id.resourceId);
        if(drawable == null)
            return null;
        // 取 drawable 的颜色格式
        Bitmap.Config config = drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888
                : Bitmap.Config.RGB_565;
        // 建立对应 bitmap
        Bitmap bitmap = Bitmap.createBitmap(w, h, config);
        // 建立对应 bitmap 的画布
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, w, h);
        // 把 drawable 内容画到画布中
        drawable.draw(canvas);
        drawable = new BitmapDrawable(bitmap);
        //图片操作是很耗资源的，记得要释放不需要的临时变量
        canvas = null;
        bitmap = null;
        return drawable;
    }


/*    //设置drawablleft/设置drawablRigh
    //变换完图片的大小后，我们就可以去设置要显示的图片了
    //调用该方法后一定要判断是否为null
    Drawable drawable = zoomDrawable(x,x,x);
     if(drawable != null){
        id_show_data_num.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
        //图片操作是很耗资源的，记得要释放不需要的临时变量
        drawable = null;
    }*/
}
