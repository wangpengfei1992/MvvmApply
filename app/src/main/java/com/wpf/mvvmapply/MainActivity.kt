package com.wpf.mvvmapply

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.wpf.common.ext.setupWithNavController


import com.wpf.common_ui.base.BaseActivity
import com.wpf.common_ui.utils.LogUtil
import com.wpf.mvvmapply.databinding.ActivityMainBinding

/**
 *  Author: feipeng.wang
 *  Time:   2021/7/14
 *  Description : This is description.
 */
class MainActivity :BaseActivity<ActivityMainBinding>(){
    override fun getViewBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)

    override fun onCreateAfter(savedInstanceState: Bundle?) {
        setupBottomNavigationBar()
    }
    private fun setupBottomNavigationBar() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        mViewBinding.bottomNavView.setupWithNavController(navController)
        mViewBinding.bottomNavView.setOnItemSelectedListener {
            LogUtil.e(TAG,"setOnItemSelectedListener,${it.itemId}")
            it.onNavDestinationSelected(navController) || super.onOptionsItemSelected(it)
        }
    }
}