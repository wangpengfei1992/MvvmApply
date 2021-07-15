package com.wpf.mvvmapply

import android.os.Bundle
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.callback.NavigationCallback
import com.wpf.common_arouter.CoreRouterResult
import com.wpf.common_ui.base.BaseActivity
import com.wpf.common_ui.utils.LogUtil
import com.wpf.func_conmmon.help.Constants
import com.wpf.mvvmapply.databinding.ActivityTestMainBinding

class TestMainActivity : BaseActivity<ActivityTestMainBinding>() {
    override fun getViewBinding(): ActivityTestMainBinding = ActivityTestMainBinding.inflate(layoutInflater)

    override fun onCreateAfter(savedInstanceState: Bundle?) {
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


