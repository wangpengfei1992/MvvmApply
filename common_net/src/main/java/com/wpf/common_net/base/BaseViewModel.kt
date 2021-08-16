package com.wpf.common_net.base

import android.util.Log
import androidx.lifecycle.*
import com.wpf.common_net.bean.BaseResp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

/**
 *  Author: feipeng.wang
 *  Time:   2021/7/8
 *  Description : This is description.
 */
typealias EmitBlock<T> = suspend LiveDataScope<T>.() -> T
typealias EmitBlock1<T> = suspend MutableLiveData<T>.() -> T

open class BaseViewModel :ViewModel(){
    fun <T:Any> launch(block: suspend ()->StateLiveData<T>){
        viewModelScope.launch{
            block()
        }
    }


    /*异步请求同步检测*/
    fun <T : Any> emitEnter1(block: EmitBlock<BaseResp<T>>): LiveData<BaseResp<T>> = liveData {
        try {
            var result: BaseResp<T>? = null
            Log.e("wpf","emitEnter1===开始")
            withContext(Dispatchers.IO) {
                result = block()
            }
            emit(result!!)
        }catch (e:Exception){
            Log.e("wpf","emitEnter1===异常")
            var result: BaseResp<T> = BaseResp<T>()
            result.errorMsg = e.message
            result.errorCode = -1
            result.error = e
            emit(result!!)
        }
    }

    //启动协程处理任务
    fun launchOnIO(block: suspend () -> Unit) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                block()
            }
        }
    }
}