package com.wpf.common_ui.base

import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding

/**
 *  Author: feipeng.wang
 *  Time:   2021/7/7
 *  Description : This is description.
 */
abstract class BaseVMFragment<VM:BaseUiViewModel,VB : ViewBinding> :BaseFragment<VB>(){
    lateinit var mViewModel: VM
    override fun onCreateAfter() {
        providerVMClass()?.let {
            mViewModel =  ViewModelProvider(this).get(it)
        }
    }
    open fun providerVMClass():Class<VM>? = null
}