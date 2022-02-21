package com.wpf.common_base.utils;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.RelativeLayout;

import java.util.HashMap;
import java.util.Map;

/**
 * oAuthor:${李强}
 * date:2018/2/28
 * time:16:48
 * projectName:energycloud
 */

public class DisplayUtil {
    private static Map<ScreenEnum,Integer> screenMap = new HashMap<>();
    /**
     * 将px值转换为dip或dp值，保证尺寸大小不变
     *
     * @param pxValue
     * @return
     */
    public static int px2dip(float pxValue, Activity activity) {
        return (int) (pxValue / getScreenMsg(activity).get(ScreenEnum.Density) + 0.5f);
    }
    /**
     * 将dip或dp值转换为px值，保证尺寸大小不变
     * @return
     */
    public static int dip2px(float dipValue, Activity activity) {
        return (int) (dipValue * getScreenMsg(activity).get(ScreenEnum.Density) + 0.5f);
    }
    /**
     * 将px值转换为sp值，保证文字大小不变
     *
     * @return
     */
    public static int px2sp(float pxValue, Activity activity) {
        return (int) (pxValue / getScreenMsg(activity).get(ScreenEnum.ScaledDensity) + 0.5f);
    }
    /**
     * 将sp值转换为px值，保证文字大小不变
     * @return
     */
    public static int sp2px(float spValue, Activity activity) {
        return (int) (spValue * getScreenMsg(activity).get(ScreenEnum.ScaledDensity) + 0.5f);
    }

    /**
     * 将sp值转换为px值，保证文字大小不变
     * @return
     */
    public static int sp2px(float spValue, Context activity) {
        return (int) (spValue * getScreenMsg(activity).get(ScreenEnum.ScaledDensity) + 0.5f);
    }

    /**
     * dp转px
     */
    public static int dp2px(Context context, float dpVal) {
        if (context==null) return (int) (dpVal * 2 + 0.5f);
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dpVal, context.getResources().getDisplayMetrics());
    }


    /**
     * 获取屏幕尺寸等信息
     */
    public static Map<ScreenEnum,Integer> getScreenMsg(Activity activity){
        DisplayMetrics metric = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metric);

        int width = metric.widthPixels;
        int height = metric.heightPixels;
        float density = metric.density;///屏幕密度（0.75, 1.0 . 1.5）
        int densityDpi = metric.densityDpi;///屏幕密度DPI（120/160/240/320/480）
        float scaledDensity = metric.scaledDensity;
        if (screenMap==null) screenMap = new HashMap<>();

        screenMap.clear();
        screenMap.put(ScreenEnum.Width,width);
        screenMap.put(ScreenEnum.Height,height);
        screenMap.put(ScreenEnum.Density,(int)density);
        screenMap.put(ScreenEnum.DendityDpi,densityDpi);
        screenMap.put(ScreenEnum.ScaledDensity, (int)scaledDensity);
        return screenMap;
    }


    /**
     * 获取屏幕尺寸等信息
     */
    public static Map<ScreenEnum,Integer> getScreenMsg(Context activity){
        DisplayMetrics metric = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) activity.getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(metric);
        int width = metric.widthPixels;
        int height = metric.heightPixels;
        float density = metric.density;///屏幕密度（0.75, 1.0 . 1.5）
        int densityDpi = metric.densityDpi;///屏幕密度DPI（120/160/240/320/480）
        float scaledDensity = metric.scaledDensity;
        if (screenMap==null) screenMap = new HashMap<>();

        screenMap.clear();
        screenMap.put(ScreenEnum.Width,width);
        screenMap.put(ScreenEnum.Height,height);
        screenMap.put(ScreenEnum.Density,(int)density);
        screenMap.put(ScreenEnum.DendityDpi,densityDpi);
        screenMap.put(ScreenEnum.ScaledDensity, (int)scaledDensity);
        return screenMap;
    }

    public static enum ScreenEnum{
        Width,Height,Density,DendityDpi,ScaledDensity
    }

    /**
     * EditText获取焦点并显示软键盘
     */
    public static void showSoftInputFromWindow(Activity activity, EditText editText) {
        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
        editText.requestFocus();
        activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
    }

    /**
     * 设置控件所在的位置XY，并且不改变宽高，
     * XY为绝对位置
     */
    public static void setLayout(View view, int x, int y)
    {
        ViewGroup.MarginLayoutParams margin=new ViewGroup.MarginLayoutParams(view.getLayoutParams());
        margin.setMargins(x,y, x+margin.width, y+margin.height);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(margin);
        view.setLayoutParams(layoutParams);
    }

    public static void setMargins (View v, int l, int t, int r, int b) {
        if (v.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
            p.setMargins(l, t, r, b);
            v.requestLayout();
        }
    }

}
