package com.wpf.func_personal.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.wpf.common_ui.base.BaseFragment
import com.wpf.common_ui.base.BaseVMFragment
import com.wpf.func_personal.databinding.FragmentPersonalBinding
import com.wpf.func_personal.vm.PersonUiViewModel

/**
 *  Author: feipeng.wang
 *  Time:   2021/7/13
 *  Description : This is description.
 */
class PersonalFragment : BaseVMFragment<PersonUiViewModel,FragmentPersonalBinding>() {

    override fun providerVMClass(): Class<PersonUiViewModel>? {
        return PersonUiViewModel::class.java
    }

    override fun onCreateAfter() {
        super.onCreateAfter()
        mViewModel.test()

    }
}