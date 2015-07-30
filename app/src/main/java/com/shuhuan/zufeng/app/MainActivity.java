package com.shuhuan.zufeng.app;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.widget.RadioGroup;
import com.shuhuan.zufeng.app.fragments.CustomFragment;
import com.shuhuan.zufeng.app.fragments.DiscoveryFragment;
import com.shuhuan.zufeng.app.fragments.DownloadTingFragment;
import com.shuhuan.zufeng.app.fragments.ProfileFragment;

/**
 *
 * 主界面
 *
 */

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

    private DiscoveryFragment discoveryFragment;
    private CustomFragment customFragment;
    private DownloadTingFragment downloadTingFragment;
    private ProfileFragment profileFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ////////////////////////////////////////////////

        setTitle("主界面");


        //////////////////////////////////////////////
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
                if (discoveryFragment == null) {
                    discoveryFragment = new DiscoveryFragment();
                }
                fragment= discoveryFragment;
                break;
            case R.id.main_tab_item_custom1:
                if (customFragment == null) {
                    customFragment = new CustomFragment();
                }
                fragment= customFragment;
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

        if(fragment == null){
            Log.d("----------","null");
        } else {
            Log.d("----------","not null");
        }

        transaction.replace(R.id.main_fragment_container,fragment);
        transaction.commit();

    }

    @Override
    protected int outExitAnimationId() {
        return 0;
    }
}
