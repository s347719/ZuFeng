package com.shuhuan.zufeng.app.tasks;

import android.os.AsyncTask;

/**
 * Created with Intellij IDEA.
 * Project:ZuFeng
 * user:MIKE Shu
 * Email:578076417@qq.com
 * Created on 2015/7/28.
 */

/**
 * BaseTask
 * 抽象的异步任务
 */
public abstract class BaseTask extends AsyncTask<String,Integer,TaskResult> {


    private TaskCallback callback;

    public BaseTask(TaskCallback callback) {
        this.callback = callback;
    }


    @Override
    protected void onPostExecute(TaskResult taskResult) {

        if (callback != null) {
            callback.onTaskFinished(taskResult);
        }
    }
}
