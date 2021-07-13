package com.wpf.common_arouter

import android.content.Context
import android.os.Bundle
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.callback.NavigationCallback
import com.alibaba.android.arouter.launcher.ARouter
import java.lang.Exception
import java.util.*
import java.util.concurrent.ConcurrentHashMap


/**
 *  Author: feipeng.wang
 *  Time:   2021/7/12
 *  Description : This is description.
 */

class ARouterConstant private constructor(){
    companion object{
        val instance:ARouterConstant by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED){
            ARouterConstant()
        }
        const val AROUTER_KEY_CALLBACK = "ARouterConstant_AROUTER_KEY_CALLBACK"
    }
    var cacherMap:MutableMap<String,CoreRouterResult> = ConcurrentHashMap<String,CoreRouterResult>()

}

fun Context.aRouter(
    postcard: Postcard,
    navigationCallback: NavigationCallback? = null,
    resultCallBack: CoreRouterResult? = null
) {
    if (postcard == null){
        throw Exception("In ARouterConstant ，postcard is null")
    }
    var keyID:String = ""
    if (resultCallBack != null){
        keyID = UUID.randomUUID().toString().replace("-","")
        postcard.withString(ARouterConstant.AROUTER_KEY_CALLBACK,keyID)
        if (keyID.isNotEmpty()){
            ARouterConstant.instance.cacherMap[keyID] = resultCallBack
        }
    }
    if (navigationCallback != null){
        postcard.navigation(this,object : NavigationCallback{
            override fun onFound(postcard: Postcard?) {
                navigationCallback.onFound(postcard)
            }

            override fun onLost(postcard: Postcard?) {
                postcardOnCancel(keyID)
                navigationCallback.onLost(postcard)
            }

            override fun onArrival(postcard: Postcard?) {
                navigationCallback.onArrival(postcard)
            }

            override fun onInterrupt(postcard: Postcard?) {
                postcardOnCancel(keyID)
                navigationCallback.onInterrupt(postcard)
            }

            private fun postcardOnCancel(keyID: String) {
                if (ARouterConstant.instance.cacherMap.containsKey(keyID)){
                    ARouterConstant.instance.cacherMap.remove(keyID)
                }
            }

        })
    }
}
fun withArouterData(path:String,bundle: Bundle ?= null):Postcard{
    if (path.isNullOrEmpty()){
        throw Exception("In ARouterConstant ，path is null")
    }
    var postcard = ARouter.getInstance().build(path)
    bundle?.let {
        postcard.with(bundle)
    }
    return postcard
}

fun Context.postcardOnResult(keyID:String?,reslut:String = ""){
    keyID?.let { key ->
        if (ARouterConstant.instance.cacherMap.containsKey(key)){
            ARouterConstant.instance.cacherMap[key]?.let {
                it.onResult(reslut)
            }
        }
    }

}