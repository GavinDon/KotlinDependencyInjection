package com.gavin.kotlindependencyinjection.ui

import android.os.Bundle
import androidx.navigation.Navigation
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.ashokvarma.bottomnavigation.BottomNavigationItem
import com.gavin.kotlindependencyinjection.R
import com.gavin.kotlindependencyinjection.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : BaseActivity() {
    override val layoutId: Int
        get() = R.layout.activity_main2

    override fun initView(savedInstanceState: Bundle?) {

        val navController = Navigation.findNavController(this,R.id.main_fragment)

        bottom_bar.setMode(BottomNavigationBar.MODE_FIXED)
                .addItem(BottomNavigationItem(R.mipmap.ic_launcher, "首页").setActiveColor(R.color.colorPrimary))
                .addItem(BottomNavigationItem(R.mipmap.ic_launcher, "内容").setActiveColor(R.color.colorPrimary))
                .addItem(BottomNavigationItem(R.mipmap.ic_launcher, "个人中心").setActiveColor(R.color.colorPrimary))
                .setFirstSelectedPosition(0)
                .setTabSelectedListener(object : BottomNavigationBar.OnTabSelectedListener {
                    override fun onTabReselected(position: Int) {
                    }

                    override fun onTabUnselected(position: Int) {
                    }

                    override fun onTabSelected(position: Int) {
                        when(position){
                            0 ->navController.navigate(R.id.home)
                            1->navController.navigate(R.id.second)
                            2->navController.navigate(R.id.personal)
                        }

                    }

                }).initialise()

    }


}
