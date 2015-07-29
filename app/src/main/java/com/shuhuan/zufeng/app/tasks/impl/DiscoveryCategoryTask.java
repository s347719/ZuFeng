package com.shuhuan.zufeng.app.tasks.impl;

import com.shuhuan.zufeng.app.Constants;
import com.shuhuan.zufeng.app.client.ClientDiscoveryAPI;
import com.shuhuan.zufeng.app.tasks.BaseTask;
import com.shuhuan.zufeng.app.tasks.TaskCallback;
import com.shuhuan.zufeng.app.tasks.TaskResult;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created with Intellij IDEA.
 * Project:ZuFeng
 * user:MIKE Shu
 * Email:578076417@qq.com
 * Created on 2015/7/29.
 */
public class DiscoveryCategoryTask extends BaseTask {

    public DiscoveryCategoryTask(TaskCallback callback) {
        super(callback);
    }

    @Override
    protected TaskResult doInBackground(String... params) {
        TaskResult ret = new TaskResult();

        ret.taskId = Constants.TASK_DISCOVERY_CATEGORYS;
        String str = ClientDiscoveryAPI.getDiscoveryCategories();

        try {
            ret.data = new JSONObject(str);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return ret;
    }
}
