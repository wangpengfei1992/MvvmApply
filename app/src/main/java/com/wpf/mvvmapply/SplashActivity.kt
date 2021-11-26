package com.wpf.mvvmapply

import android.os.Bundle
import com.wpf.common.ext.startAct
import com.wpf.common_ui.base.BaseActivity
import com.wpf.mvvmapply.databinding.ActivitySplashBinding

/**
 *  Author: feipeng.wang
 *  Time:   2021/7/14
 *  Description : This is description.
 */
class SplashActivity : BaseActivity<ActivitySplashBinding>(){
    override fun getViewBinding(): ActivitySplashBinding = ActivitySplashBinding.inflate(layoutInflater)

    override fun onCreateAfter(savedInstanceState: Bundle?) {
        startAct<MainActivity>(this)
        finish()
    }
}