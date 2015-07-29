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
 * Created on 2015/7/28.
 */

/**
 *
 * CategoryTagMenu<br/>
 * 这个任务支持一个参数，参数的内容是type的值，目前只可以些user
 */
public class CategoryTagMenuTask extends BaseTask {


    public CategoryTagMenuTask(TaskCallback callback) {
        super(callback);
    }

    @Override
    protected TaskResult doInBackground(String... params) {
        /////////////////////////////////

        //TaskResult 必须创建，用来描述任务类型以及数据
        TaskResult ret = new TaskResult();

        ret.taskId = Constants.TASK_CATEGORY_TAG_MENU;

        ////////////////////////

        String type =null;
        if (params!=null && params.length>0)
        {
            type =params[0];
        }

        String str = ClientDiscoveryAPI.getCategoryTagMenu(type);
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
