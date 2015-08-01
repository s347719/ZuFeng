package com.shuhuan.zufeng.app.util;

/**
 * Created with Intellij IDEA.
 * Project:ZuFeng
 * user:MIKE Shu
 * Email:578076417@qq.com
 * Created on 2015/7/31.
 */

import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * 未捕获异常处理器
 */
public class UncaughtExceptionHandlerimpl implements Thread.UncaughtExceptionHandler{
    /**
     *
     * 获取文件路径用的
     * 因为是全局的所以context 是最高层级的
     */
    private Context context;

    public UncaughtExceptionHandlerimpl(Context context) {
        this.context = context;
    }

    /**
     * 当某一个线程发生了未捕获异常的时候回调这个方法
     *
     * @param thread
     * @param ex
     */
    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        //TODO  将异常信息，保存到文件中。

        if (context != null) {

            File filesDir =context.getFilesDir();

//            String state  = Environment.getExternalStorageState();
//            if (state.equals(Environment.MEDIA_MOUNTED))
//            {
//                filesDir = context.getExternalFilesDir(null);
//            }
            File logFile = new File(filesDir,"app.log");

            FileWriter fw = null;
            PrintWriter pw = null;
            try{
                fw = new FileWriter(logFile);
                pw = new PrintWriter(fw);
                ex.printStackTrace(pw);

            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

            finally {
                StreamUtil.close(pw);
                StreamUtil.close(fw);

            }

        }
    }
}
