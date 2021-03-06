package com.wpf.func_login.ui

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.wpf.common_base.utils.LogUtil
import com.wpf.common_net.base.callBackObserver
import com.wpf.common_ui.base.BaseActivity
import com.wpf.func_conmmon.help.Constants
import com.wpf.func_login.databinding.ActivityLoginMainBinding
import com.wpf.func_login.viewmodel.LoginViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 *  Author: feipeng.wang
 *  Time:   2021/7/8
 *  Description : This is description.
 */
@Route(path = Constants.RouterPath.LOGIN_ACTIVITY_PATH)
class LoginActivity : BaseActivity<ActivityLoginMainBinding>() {

    private val mViewModel: LoginViewModel by viewModel()

    override fun onCreateAfter(savedInstanceState: Bundle?) {
        mViewBinding.login.setOnClickListener {
            //登录方式1
            mViewModel.login("123", "123456")
        }
        mViewBinding.rigster.setOnClickListener {
            aRouterOk(reslut = "我想返回什么呢")
            finish()
        }
        mViewModel.loginLiveData.callBackObserver(this,{
            LogUtil.e(TAG,"成功")
        },{
            LogUtil.e(TAG,"失败，${it.errorMsg}")
        },{
            LogUtil.e(TAG,"开始")
        })
    }
}