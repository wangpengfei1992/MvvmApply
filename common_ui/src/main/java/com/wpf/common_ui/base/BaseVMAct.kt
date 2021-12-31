package com.wpf.common_ui.base

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding

/**
 *  Author: feipeng.wang
 *  Time:   2021/7/7
 *  Description : This is description.
 */
abstract class BaseVMAct<VM:BaseUiViewModel,VB : ViewBinding> : BaseActivity<VB>() {
    lateinit var mViewModel: VM
    override fun onCreateBefore(savedInstanceState: Bundle?) {
        super.onCreateBefore(savedInstanceState)
        providerVMClass()?.let {
            mViewModel =  ViewModelProvider(this).get(it)
        }
    }
    open fun providerVMClass():Class<VM>? = null
}