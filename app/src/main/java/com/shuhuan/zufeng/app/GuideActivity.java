package com.shuhuan.zufeng.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.shuhuan.zufeng.app.adapters.GuideAdapter;
import com.shuhuan.zufeng.app.util.PackageUtil;

import java.util.ArrayList;


public class GuideActivity extends FragmentActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_guide);
        ViewPager pager = (ViewPager) findViewById(R.id.guide_view_pager);
        if (pager != null) {

            ArrayList<Integer> images = new ArrayList<Integer>();
            for (int i = 0; i <4; i++) {
                images.add(R.mipmap.ic_launcher);
            }
            GuideAdapter adapter = new GuideAdapter(this,images);
            //设置 Adapter 的内部点击事件

            adapter.setGuideGoOnClickListener(this);

            pager.setAdapter(adapter);

        }

        //////////////////////////////////////
        //设置SharedPreference，只要教程页出来就设置

        SharedPreferences sp = getSharedPreferences(Constants.SP_NAME, MODE_PRIVATE);
        String versionName = PackageUtil.getPackageVersionName(this);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(Constants.SP_KEY_GUIDE_LAST_SHOW_VERSION,versionName);
        editor.commit();
    }


    @Override
    public void onClick(View v) {

        startMain();
    }

    private void startMain() {
        Intent intent = new Intent(this,MainActivity.class);

        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        startMain();

    }
}
