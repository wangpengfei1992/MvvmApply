package com.wpf.func_conmmon.help

import com.alibaba.android.arouter.launcher.ARouter

/**
 *  Author: feipeng.wang
 *  Time:   2021/7/12
 *  Description : This is description.
 */

object ARouterExtension{
    fun aRouter(path:String){
        ARouter.getInstance().build(path).navigation()
    }
}