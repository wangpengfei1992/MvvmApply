package com.wpf.mvvmapply

import com.wpf.common_player.control.PlayerControl
import com.wpf.common_ui.base.BaseApplication
import com.wpf.func_home.di.homeModul
import com.wpf.func_login.di.loginModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.module.Module

/**
 *  Author: feipeng.wang
 *  Time:   2021/7/7
 *  Description : This is description.
 */
class MainApplication : BaseApplication() {
    private val allModules = arrayListOf<Module>(loginModule,homeModul)
    override fun onCreateAfter() {
        initKoin()
        PlayerControl.instance.init(this)
    }

    private fun initKoin() {
        startKoin{
            androidContext(this@MainApplication)
            modules(allModules)
        }
    }

}