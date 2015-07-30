package com.shuhuan.zufeng.app.fragments.discover;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.shuhuan.zufeng.app.R;
import com.shuhuan.zufeng.app.SettingsActivity;
import com.shuhuan.zufeng.app.Test1Activity;

/**
 * Created with Intellij IDEA.
 * Project:ZuFeng
 * user:MIKE Shu
 * Email:578076417@qq.com
 * Created on 2015/7/29.
 */
public class DiscoveryRecommendFragment extends Fragment implements View.OnClickListener {

    public DiscoveryRecommendFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View ret =  inflater.inflate(R.layout.fragment_discovery_recommend, container, false);

        Button btn = (Button) ret.findViewById(R.id.btn_recommend);

        Button btn1 = (Button) ret.findViewById(R.id.btnSettings);

        btn1.setOnClickListener(this);
        btn.setOnClickListener(this);
        return ret;
    }

    @Override
    public void onClick(View v) {
        FragmentActivity context = getActivity();


        int id = v.getId();

        switch (id)
        {
            case R.id.btn_recommend:
                Intent intent = new Intent(context, Test1Activity.class);
                startActivity(intent);

                break;

            case R.id.btnSettings:
                Intent intent1 = new Intent(context, SettingsActivity.class);
                startActivity(intent1);

                break;

        }

        //对于 startActivity 新的是进入
        // 动画指定的ID 为0 代表没有动画
        context.overridePendingTransition(R.anim.anim_slide_to_left,R.anim.anim_empty_exit);
    }


}
