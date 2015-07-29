package com.shuhuan.zufeng.app;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;
import com.shuhuan.zufeng.app.fragments.CustmFragment;
import com.shuhuan.zufeng.app.fragments.DiscoveryFragment;
import com.shuhuan.zufeng.app.fragments.DownloadTingFragment;
import com.shuhuan.zufeng.app.fragments.ProfileFragment;


public class MainActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener {

    private DiscoveryFragment discoveryFragment;
    private CustmFragment customFrgment;
    private DownloadTingFragment downloadTingFragment;
    private ProfileFragment profileFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RadioGroup tabBar = (RadioGroup) findViewById(R.id.main_tab_bar);
        tabBar.setOnCheckedChangeListener(this);
        //默认选中第一个
        tabBar.check(R.id.main_tab_item_discovery);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentManager manager  = getSupportFragmentManager();

        FragmentTransaction transaction = manager.beginTransaction();
        Fragment fragment = null;
        switch (checkedId)
        {
            case R.id.main_tab_item_discovery:
                if (discoveryFragment != null) {
                    discoveryFragment = new DiscoveryFragment();
                }
                fragment= discoveryFragment;
                break;
            case R.id.main_tab_item_custom1:
                if (customFrgment == null) {
                    customFrgment = new CustmFragment();
                }
                fragment= customFrgment;
                break;
            case R.id.main_tab_item_download:
                if (downloadTingFragment == null) {
                    downloadTingFragment = new DownloadTingFragment();
                }
                fragment= downloadTingFragment;
                break;
            case R.id.main_tab_item_profile:
                if (profileFragment == null) {
                    profileFragment = new ProfileFragment();
                }
                fragment = profileFragment;
                break;
        }

        transaction.replace(R.id.main_fragment_container,fragment);
        transaction.commit();

    }
}
