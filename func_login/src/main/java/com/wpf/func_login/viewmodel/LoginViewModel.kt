package com.wpf.func_login.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.wpf.common_net.base.BaseViewModel
import com.wpf.common_net.base.StateLiveData
import com.wpf.common_net.bean.BaseResp
import com.wpf.func_conmmon.bean.LoginResponse
import com.wpf.func_login.api.LoginRep
import kotlinx.coroutines.launch

/**
 *  Author: feipeng.wang
 *  Time:   2021/7/8
 *  Description : This is description.
 */
class LoginViewModel(var repository: LoginRep) :BaseViewModel() {
    var loginLiveData = StateLiveData<LoginResponse>()
    var rigesterLiveData = StateLiveData<LoginResponse>()

    fun login(userName: String, password: String) {
        launch{
            repository.login(userName, password,loginLiveData)
        }
    }

    fun loginAndResult1(userName: String, password: String):LiveData<BaseResp<LoginResponse>>
            = emitEnter1 {
        repository.login1(userName, password)
    }
    fun rigester( userName: String,
                  password: String,
                  rePassword: String,){
        launch{
            repository.rigester(userName, password,rePassword,rigesterLiveData)
        }
    }
}