package com.wpf.func_personal.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.wpf.common_ui.base.BaseFragment
import com.wpf.func_personal.databinding.FragmentPersonalBinding

/**
 *  Author: feipeng.wang
 *  Time:   2021/7/13
 *  Description : This is description.
 */
class PersonalFragment : BaseFragment<FragmentPersonalBinding>() {
    override fun getViewBinding(
        inflater: LayoutInflater,
        viewGroup: ViewGroup?
    ): FragmentPersonalBinding = FragmentPersonalBinding.inflate(inflater,viewGroup,false)
}