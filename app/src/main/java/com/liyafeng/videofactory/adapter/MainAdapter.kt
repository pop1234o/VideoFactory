package com.liyafeng.videofactory.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.liyafeng.module_convert.ui.MainConvertFragment
import com.liyafeng.module_mine.ui.MineFragment

class MainAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(i: Int): Fragment {
        return if (i == 0) {
            MainConvertFragment.newInstance()
        } else {
            MineFragment()
        }
    }

    override fun getCount(): Int {
        return 2
    }
}
