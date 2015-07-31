package com.shuhuan.zufeng.app.util;

/**
 * Created with Intellij IDEA.
 * Project:ZuFeng
 * user:MIKE Shu
 * Email:578076417@qq.com
 * Created on 2015/7/31.
 */

import android.util.Log;
import com.shuhuan.zufeng.app.BuildConfig;

/**
 *
 * 封装  Android Log 工具，能够增加日志的开关
 * 存在的作用是在调试的时候才有作用
 */
public final class MyLog {

    /**
     * 日志的开关 在Release （发布软件的时候） 关闭日志
     */
    private static final boolean ON = BuildConfig.DEBUG;
    /**
     *
     * 通过变量控制日志的输出
     */
    private static final boolean DEBUG = true;
    private static final boolean INFO = true;

    private MyLog() {

    }
    public static void d(String tag,String msg) {
        if (ON) {
            if (DEBUG) {
                Log.d(tag, msg);
            }
        }
    }
    public static void i(String tag,String msg){
        if (ON){
        if (INFO) {
            Log.i(tag, msg);
            }
        }
    }
}
