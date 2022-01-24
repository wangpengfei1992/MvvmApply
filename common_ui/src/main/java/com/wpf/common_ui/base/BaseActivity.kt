package com.wpf.common_ui.base

import android.os.Bundle
import android.os.Looper
import android.os.Message
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.callback.NavigationCallback
import com.wpf.common_arouter.*
import com.wpf.common_base.utils.StatusBar
import com.wpf.common_ui.utils.WeakHandler
import java.lang.reflect.InvocationTargetException
import java.lang.reflect.Method
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type


/**
 *  Author: feipeng.wang
 *  Time:   2021/7/7
 *  Description : This is description.
 */
abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {
    protected val TAG = this::class.java.simpleName
    private lateinit var _binding: VB
    protected val mViewBinding get() = _binding
    lateinit var mBaseHandler: WeakHandler
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
    abstract fun onCreateAfter(savedInstanceState: Bundle?)
    open fun handleMessage(msg: Message) {}
    private fun getViewBinding(): VB{
        var superclass: Type = javaClass.genericSuperclass
        //多加了一层instanceof的判断
        if (superclass !is ParameterizedType){
            superclass = javaClass.superclass.genericSuperclass
        }
        val aClass:Class<VB> = (superclass as ParameterizedType).actualTypeArguments[0] as Class<VB>
        try {
            val method: Method =aClass.getDeclaredMethod("inflate", LayoutInflater::class.java)
            _binding = method.invoke(null, layoutInflater) as VB
        } catch (e: NoSuchMethodException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: InvocationTargetException) {
            e.printStackTrace()
        }
        return _binding
    }

    /*路由方法*/
    fun aRouter(path: String, bundle: Bundle? = null, navigationCallback: NavigationCallback? = null,
                resultCallBack: CoreRouterResult? = null){
        aRouter(withArouterData(path, bundle), navigationCallback, resultCallBack)
    }
    fun aRouter(postcard: Postcard, navigationCallback: NavigationCallback? = null,
                resultCallBack: CoreRouterResult? = null){
        baseContext.aRouter(postcard, navigationCallback, resultCallBack)
    }
    fun aRouterOk(reslut: String = ""){
        baseContext.postcardOnResult(keyID, reslut)
    }
}