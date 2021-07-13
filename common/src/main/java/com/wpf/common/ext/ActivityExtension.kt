package com.wpf.common.ext

import android.content.Context
import android.content.Intent

/**
 *  Author: feipeng.wang
 *  Time:   2021/7/9
 *  Description : This is description.
 */

 inline fun <reified T> startAct(context: Context){
     var intent = Intent(context,T::class.java)
     context.startActivity(intent)
 }

inline fun <reified T> startActAndMsg(context: Context,block:Intent.()->Unit){
    var intent = Intent(context,T::class.java)
    intent.block()
    context.startActivity(intent)
}