package com.wpf.common_ui.base

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.alibaba.android.arouter.launcher.ARouter
import com.wpf.common_ui.BuildConfig
import com.wpf.common_base.utils.ContextUtil

/**
 *  Author: feipeng.wang
 *  Time:   2021/7/7
 *  Description : This is description.
 */
abstract class BaseApplication : Application() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(base)
    }
    override fun onCreate() {
        super.onCreate()
        ContextUtil.initContext(this)
        onCreateAfter()
        intArouter()
    }

    private fun intArouter() {
        if (BuildConfig.DEBUG){
            ARouter.openLog();
            ARouter.openDebug();
        }

        ARouter.init(this);
    }

    abstract fun onCreateAfter()
}