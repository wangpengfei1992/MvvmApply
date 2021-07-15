package com.wpf.func_personal.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.wpf.common_ui.base.BaseFragment
import com.wpf.func_home.databinding.FragmentHomeBinding
/**
 *  Author: feipeng.wang
 *  Time:   2021/7/13
 *  Description : This is description.
 */
class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override fun getViewBinding(
        inflater: LayoutInflater,
        viewGroup: ViewGroup?
    ): FragmentHomeBinding = FragmentHomeBinding.inflate(inflater,viewGroup,false)
}