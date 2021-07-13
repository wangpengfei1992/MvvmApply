package com.wpf.mvvmapply

import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.callback.NavigationCallback
import com.alibaba.android.arouter.launcher.ARouter
import com.wpf.common_arouter.CoreRouterResult
import com.wpf.common_ui.base.BaseActivity
import com.wpf.common_ui.utils.LogUtil
import com.wpf.func_conmmon.help.ARouterExtension
import com.wpf.func_conmmon.help.Constants
import com.wpf.mvvmapply.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun getViewBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)

    override fun onCreateAfter() {
        mViewBinding.login.setOnClickListener {
            aRouter(Constants.RouterPath.LOGIN_ACTIVITY_PATH,navigationCallback = object :NavigationCallback{
                override fun onFound(postcard: Postcard?) {
                    LogUtil.e(TAG,"onFound---")
                }

                override fun onLost(postcard: Postcard?) {
                    LogUtil.e(TAG,"onLost---")
                }

                override fun onArrival(postcard: Postcard?) {
                    LogUtil.e(TAG,"onArrival---")
                }

                override fun onInterrupt(postcard: Postcard?) {
                    LogUtil.e(TAG,"onInterrupt---")
                }

            }, resultCallBack = object : CoreRouterResult{
                override fun onResult(result: String) {
                    LogUtil.e(TAG,"onResult---${result}")
                }

            })
//            ARouterExtension.aRouter(Constants.RouterPath.LOGIN_ACTIVITY_PATH)
        }
        mViewBinding.rigster.setOnClickListener {

        }
    }

}


