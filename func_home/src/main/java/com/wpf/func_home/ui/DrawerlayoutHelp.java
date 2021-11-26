package com.wpf.func_home.ui;

import android.content.Context;
import android.graphics.Point;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.customview.widget.ViewDragHelper;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentActivity;

import java.lang.reflect.Field;

/**
 * Author: feipeng.wang
 * Time:   2021/11/26
 * Description : This is description.
 */
public class DrawerlayoutHelp {

    public static void change(FragmentActivity appCompatActivity, DrawerLayout mDrawerLayout, LinearLayout mLinearLayout){
        View mContent = mDrawerLayout.getChildAt(0);//获取主页面布局, 可以看到主页面布局是父布局的第一个子布局, 可以这样获得, 也可以定义id

        try {
            Field leftDraggerField = mDrawerLayout.getClass().getDeclaredField("mLeftDragger");//通过反射获得DrawerLayout类中mLeftDragger字段
            leftDraggerField.setAccessible(true);//私有属性要允许修改
            ViewDragHelper vdh = (ViewDragHelper) leftDraggerField.get(mDrawerLayout);//获取ViewDragHelper的实例, 通过ViewDragHelper实例获取mEdgeSize字段
            Field edgeSizeField = vdh.getClass().getDeclaredField("mEdgeSize");//依旧是通过反射获取ViewDragHelper类中mEdgeSize字段, 这个字段控制边缘触发范围
            edgeSizeField.setAccessible(true);//依然是私有属性要允许修改
            int edgeSize = edgeSizeField.getInt(vdh);//这里获得mEdgeSize真实值
            Log.d("AAA", "mEdgeSize: "+edgeSize);//这里可以打印一下看看值是多少

            //Start 获取手机屏幕宽度，单位px
            Point point = new Point();
            appCompatActivity.getWindowManager().getDefaultDisplay().getRealSize(point);
            //End 获取手机屏幕

            Log.d("AAA", "point: "+point.x);//依然可以打印一下看看值是多少
            edgeSizeField.setInt(vdh, Math.max(edgeSize, point.x));//这里设置mEdgeSize的值！！！，Math.max函数取得是最大值，也可以自己指定想要触发的范围值，如: 500,注意单位是px
            //写到这里已经实现了，但是你会发现，如果长按触发范围，侧边栏也会弹出来，而且速度不太同步，稳定

            //Start 解决长按会触发侧边栏
            //长按会触发侧边栏是DrawerLayout类的私有类ViewDragCallback中的mPeekRunnable实现导致，我们通过反射把它置空
            Field leftCallbackField = mDrawerLayout.getClass().getDeclaredField("mLeftCallback");//通过反射拿到私有类ViewDragCallback字段
            leftCallbackField.setAccessible(true);//私有字段设置允许修改
            ViewDragHelper.Callback vdhCallback = (ViewDragHelper.Callback) leftCallbackField.get(mDrawerLayout);//ViewDragCallback类是私有类，我们返回类型定义成他的父类
            Field peekRunnableField = vdhCallback.getClass().getDeclaredField("mPeekRunnable");//我们依然是通过反射拿到关键字段，mPeekRunnable
            peekRunnableField.setAccessible(true);//不解释了
            //定义一个空的实现
            Runnable nullRunnable = new Runnable(){
                @Override
                public void run() {

                }
            };
            peekRunnableField.set(vdhCallback, nullRunnable);//给mPeekRunnable字段置空
            //End 解决长按触发侧边栏

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
