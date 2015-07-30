package com.shuhuan.zufeng.app;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;


/**
 *
 * 基础的Activity
 */
public class BaseActivity extends FragmentActivity {

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

        overridePendingTransition(0,outExitAnimationId());
    }
}
