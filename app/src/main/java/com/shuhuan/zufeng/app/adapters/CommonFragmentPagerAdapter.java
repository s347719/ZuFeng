package com.shuhuan.zufeng.app.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created with Intellij IDEA.
 * Project:ZuFeng
 * user:MIKE Shu
 * Email:578076417@qq.com
 * Created on 2015/7/29.
 */
public class
        CommonFragmentPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;
    public CommonFragmentPagerAdapter(FragmentManager fm,List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {


        return fragments.get(position);
    }

    @Override
    public int getCount() {

        int ret = 0;
        if (fragments != null) {
            ret = fragments.size();
        }

        return ret;
    }
}
