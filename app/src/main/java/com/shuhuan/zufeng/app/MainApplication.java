package com.shuhuan.zufeng.app;

import android.app.Application;
import com.shuhuan.zufeng.app.cache.FileCache;

/**
 * Created with Intellij IDEA.
 * Project:ZuFeng
 * user:MIKE Shu
 * Email:578076417@qq.com
 * Created on 2015/7/31.
 */
public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        FileCache.createInstance(getApplicationContext());
    }
}
