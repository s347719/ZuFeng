package com.shuhuan.zufeng.app;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;


/**
 *
 * 基础的Activity
 */
public class BaseActivity extends FragmentActivity {

    private TextView txtTitle;
    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);

        //TODO  进行公共的，一些控件的内容初始化

        //  只是调用了 super.setContentView  就可以 findViewById  了

        txtTitle = (TextView) findViewById(R.id.common_header_title);

    }

    @Override
    public void setTitle(CharSequence title) {
        super.setTitle(title);

        if (txtTitle != null) {

            txtTitle.setText(title);
        }
    }

    /**
     * 获取StartActivity  之后，新的Activity  进入的动<br/>
     * 默认是从左往右，可以自重写自定义动画
     * @return 返回值
     */
    protected int getEnterAnimationId(){

        return R.anim.anim_slide_to_left;
    }

    protected int outExitAnimationId(){

        return R.anim.anim_drop_down;
    }
    /**
     *
     * 启动Aactivity 并且给启动的 Activity  制定一个动画
     * @param intent  参数
     */
    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);

        overridePendingTransition(getEnterAnimationId(),0);
    }

    @Override
    public void finish() {
        super.finish();
        int outExitAnimationId = outExitAnimationId();
        if (outExitAnimationId != 0) {

            overridePendingTransition(0,outExitAnimationId);
        }
    }


}
