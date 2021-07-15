package com.wpf.common_ui.base

import android.os.Bundle
import android.os.Looper
import android.os.Message
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.callback.NavigationCallback
import com.anker.common.utils.WeakHandler
import com.wpf.common_arouter.*
import com.wpf.common_ui.utils.StatusBar
import com.wpf.common_ui.utils.StatusBarUtil

/**
 *  Author: feipeng.wang
 *  Time:   2021/7/7
 *  Description : This is description.
 */
abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {
    protected val TAG = this::class.java.simpleName
    private lateinit var _binding: VB
    protected val mViewBinding get() = _binding
    lateinit var mBaseHandler:WeakHandler
    protected lateinit var mBaseActivity: BaseActivity<VB>
    private var keyID:String ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        onCreateBefore(savedInstanceState)
        super.onCreate(savedInstanceState)
        mBaseActivity = this
        StatusBar().fitSystemBar(this)
        _binding = getViewBinding()
        setContentView(_binding.root)
        mBaseHandler = WeakHandler(this, Looper.myLooper()!!)
        keyID = intent.getStringExtra(ARouterConstant.AROUTER_KEY_CALLBACK)
        onCreateAfter(savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        if (mBaseHandler!=null){
            mBaseHandler.removeCallbacksAndMessages(null)
        }
        keyID?.let {
            ARouterConstant.instance.cacherMap.remove(keyID)
        }
    }

    open fun onCreateBefore(savedInstanceState: Bundle?){}
    abstract fun getViewBinding(): VB
    abstract fun onCreateAfter(savedInstanceState: Bundle?)
    open fun handleMessage(msg: Message) {}

    /*路由方法*/
    fun aRouter(path:String, bundle: Bundle ?= null, navigationCallback: NavigationCallback? = null,
                resultCallBack: CoreRouterResult? = null){
        aRouter(withArouterData(path,bundle),navigationCallback,resultCallBack)
    }
    fun aRouter(postcard: Postcard, navigationCallback: NavigationCallback? = null,
                resultCallBack: CoreRouterResult? = null){
        baseContext.aRouter(postcard,navigationCallback,resultCallBack)
    }
    fun aRouterOk(reslut:String = ""){
        baseContext.postcardOnResult(keyID,reslut)
    }
}