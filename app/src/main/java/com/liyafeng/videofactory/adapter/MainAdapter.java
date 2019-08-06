package com.liyafeng.videofactory.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.liyafeng.module_convert.ui.MainConvertFragment;

public class MainAdapter extends FragmentPagerAdapter {

    public MainAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        if (i == 0) {
            return MainConvertFragment.newInstance();
        } else {
            return MainConvertFragment.newInstance();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
