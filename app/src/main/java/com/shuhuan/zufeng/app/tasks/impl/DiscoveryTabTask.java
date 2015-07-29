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
public class DiscoveryTabTask extends BaseTask {

    public DiscoveryTabTask(TaskCallback callback) {
        super(callback);
    }

    @Override
    protected TaskResult doInBackground(String... params) {
        TaskResult ret = new TaskResult();

        ret.taskId = Constants.TASK_DISCOVERY_TABS;
        String str = ClientDiscoveryAPI.getDiscoveryTasbs();

        if (str != null) {
            try {
                //  返回JSON是为了让接受数据的接口实现，
                //  来检查数据的情况，不直接返回实体
                ret.data = new JSONObject(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        return ret;
    }
}
