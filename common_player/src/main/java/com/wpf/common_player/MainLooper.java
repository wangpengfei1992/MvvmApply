package com.wpf.common_player;
import android.os.Handler;
import android.os.Looper;
/**
 * Author: feipeng.wang
 * Time:   2021/11/17
 * Description : This is description.
 */

public class MainLooper {
    private static MainLooper sInstance = new MainLooper();
    private Handler mMainHandler;

    public static MainLooper instance(){
        return sInstance;
    }

    private MainLooper(){
        mMainHandler = new Handler(Looper.getMainLooper());
    }

    public void post(Runnable runnable){
        if(runnable != null){
            mMainHandler.post(runnable);
        }
    }
}