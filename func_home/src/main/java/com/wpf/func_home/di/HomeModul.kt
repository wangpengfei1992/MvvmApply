package com.wpf.func_home.di

import com.wpf.common_net.base.RetrofitManager
import com.wpf.func_home.api.HomeApi
import com.wpf.func_home.api.HomeRep
import com.wpf.func_home.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 *  Author: feipeng.wang
 *  Time:   2021/7/20
 *  Description : This is description.
 */

val homeModul = module {
    single { RetrofitManager.initRetrofit().getService(HomeApi::class.java) }
    single { HomeRep(get()) }
    viewModel{ HomeViewModel(get()) }
}