package com.wpf.func_home.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.wpf.common.room.KeyValueDb
import com.wpf.common.room.KeyValueEntity
import com.wpf.common_ui.base.BaseFragment
import com.wpf.common_base.utils.LogUtil
import com.wpf.func_home.databinding.FragmentHomeBinding
import com.wpf.func_home.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 *  Author: feipeng.wang
 *  Time:   2021/7/13
 *  Description : This is description.
 */
class TestHomeFragment : BaseFragment<FragmentHomeBinding>() {
    private val mViewModel: HomeViewModel by viewModel()
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
        }
    }
}