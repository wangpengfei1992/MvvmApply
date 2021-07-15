package com.wpf.func_personal.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.wpf.common_ui.base.BaseFragment
import com.wpf.func_project.databinding.FragmentProjectBinding

/**
 *  Author: feipeng.wang
 *  Time:   2021/7/13
 *  Description : This is description.
 */
class ProjectFragment : BaseFragment<FragmentProjectBinding>() {
    override fun getViewBinding(
        inflater: LayoutInflater,
        viewGroup: ViewGroup?
    ): FragmentProjectBinding = FragmentProjectBinding.inflate(inflater,viewGroup,false)
}