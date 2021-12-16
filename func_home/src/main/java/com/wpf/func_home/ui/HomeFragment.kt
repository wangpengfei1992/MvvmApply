package com.wpf.func_home.ui

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.Settings
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.wpf.common.room.KeyValueDb
import com.wpf.common.room.KeyValueEntity
import com.wpf.common_player.base.StatedMediaPlay
import com.wpf.common_ui.base.BaseFragment
import com.wpf.common_ui.utils.LogUtil
import com.wpf.common_ui.utils.ToastUtil
import com.wpf.func_home.databinding.FragmentHomeBinding
import com.wpf.func_home.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 *  Author: feipeng.wang
 *  Time:   2021/7/13
 *  Description : This is description.
 */
class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    private val mViewModel: HomeViewModel by viewModel()
    private val statedMediaPlay by lazy { StatedMediaPlay() }
    override fun getViewBinding(
        inflater: LayoutInflater,
        viewGroup: ViewGroup?
    ): FragmentHomeBinding = FragmentHomeBinding.inflate(inflater,viewGroup,false)

    override fun onCreateAfter() {
        mViewBinding?.apply {
            homeTestAdd.setOnClickListener {
                mViewModel.launchOnIO {
                    var keyValueEntity = KeyValueEntity(1,"name","wpf")
                    KeyValueDb.getInstance().getKeyValueDao().insert(keyValueEntity)
                }
            }
            homeTestDelet.setOnClickListener {
                mViewModel.launchOnIO {
                    KeyValueDb.getInstance().getKeyValueDao().deleteByParams("key","name")
                }
            }
            homeTestUpdate.setOnClickListener {
                mViewModel.launchOnIO {
                    var keyValueEntity = KeyValueEntity(1,"name","wpf_Update")
                    KeyValueDb.getInstance().getKeyValueDao().update(keyValueEntity)
                }
            }
            homeTestFind.setOnClickListener {
                mViewModel.launchOnIO {
                    var keyValueList = KeyValueDb.getInstance().getKeyValueDao().findAll()
                    keyValueList?.let {
                        for (i in keyValueList){
                            LogUtil.e("test",i.toString())
                        }
                    }
                }
            }

            homeTestPlayer.setOnClickListener {
/*                val wavmixPath = "/storage/emulated/0/wpf/AsrDemo3/max.wav"
                statedMediaPlay.play(wavmixPath)*/
/*                statedMediaPlay.pause()
                statedMediaPlay.resume()*/

                activity?.let { it1 -> com.wpf.common.ext.startAct<PlaySoundTestAct>(it1) }
            }
            homeTestDrawerlayout.setOnClickListener {
                //测试Drawerlayout右滑动
                if (drawerLayoutRoot.isDrawerVisible(drawerStart)){
                    drawerLayoutRoot.closeDrawer(drawerStart)
                }else{
                    drawerLayoutRoot.openDrawer(drawerStart)
                }
            }
            homeTestDrawerlayout.post {
                DrawerlayoutHelp.change(activity,drawerLayoutRoot,drawerStart)
            }

            homeTestDrawerlayoutLeft.setOnClickListener {
                //测试Drawerlayout
                if (drawerLayoutRoot.isDrawerVisible(drawerEnd)){
                    drawerLayoutRoot.closeDrawer(drawerEnd)
                }else{
                    drawerLayoutRoot.openDrawer(drawerEnd)
                }
            }

        }

        startAct()
    }
    private fun startAct(){
        chechPermisson{
            checkPermission()
        }
    }

    private val REQUEST_PERMISSION_CODE = 110
    private fun chechPermisson(sucCallBack: () -> Unit){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            // 适配android11读写权限
            if (Environment.isExternalStorageManager()) {
                //已获取android读写权限
                sucCallBack()
            } else {
                val intent:Intent = Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
                intent.setData(Uri.parse("package:" + (activity?.getPackageName() ?: "")));
                startActivityForResult(intent, REQUEST_PERMISSION_CODE);
            }
            return;
        }else {
            sucCallBack()
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_PERMISSION_CODE && Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            if (Environment.isExternalStorageManager()) {
                ToastUtil.showToast("获取文件权限成功")
                //已获取android读写权限
                startAct()
            } else {
                //存储权限获取失败
                ToastUtil.showToast("获取文件权限失败")
            }
        }
    }
    private val ALL_PERMISSIONS = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE)
    private fun checkPermission() { //判断是否有访问位置的权限，没有权限，直接申请位置权限
        if (!allPermissionsGranted()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(ALL_PERMISSIONS, 1)
            }else{
                toAct()
            }
        }else{
            toAct()
        }
    }

    private fun allPermissionsGranted() = ALL_PERMISSIONS.all {
        activity?.let { it1 -> ContextCompat.checkSelfPermission(it1, it) } == PackageManager.PERMISSION_GRANTED
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            1 -> {
                toAct()
            }
        }
    }
    private fun toAct(){

    }

}