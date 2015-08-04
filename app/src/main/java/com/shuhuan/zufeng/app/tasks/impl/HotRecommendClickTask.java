package com.shuhuan.zufeng.app.tasks.impl;

import com.shuhuan.zufeng.app.Constants;
import com.shuhuan.zufeng.app.HotRecommendActivity;
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
 * Created on 2015/8/2.
 */
public class HotRecommendClickTask extends BaseTask {

    public HotRecommendClickTask(TaskCallback callback) {
        super(callback);
    }




    @Override
    protected TaskResult doInBackground(String... params) {

        TaskResult ret = new TaskResult();

        ret.taskId = Constants.TASK_DISCOVERY_RECOMMEND_HOTRECOMMEND;
        String type = null;
        if (params != null && params.length>0) {

            type= params[0];
        }
        String str = ClientDiscoveryAPI.getHotRecommendAlbumClick(type);

        if (str != null) {

            try {
                ret.data = new JSONObject(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return ret;
    }
}
