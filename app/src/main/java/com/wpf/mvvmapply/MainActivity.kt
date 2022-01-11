package com.wpf.mvvmapply


import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.wpf.common_ui.base.BaseActivity
import com.wpf.mvvmapply.databinding.ActivityMainBinding

/**
 *  Author: feipeng.wang
 *  Time:   2021/7/14
 *  Description : This is description.
 */
class MainActivity :BaseActivity<ActivityMainBinding>(){

    override fun onCreateAfter(savedInstanceState: Bundle?) {
        setupBottomNavigationBar()
    }
    private fun setupBottomNavigationBar() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        mViewBinding.bottomNavView.setOnItemSelectedListener {
            it.onNavDestinationSelected(navController) || super.onOptionsItemSelected(it)
        }
    }
}