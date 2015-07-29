package com.shuhuan.zufeng.app.model;

/**
 * Created with Intellij IDEA.
 * Project:ZuFeng
 * user:MIKE Shu
 * Email:578076417@qq.com
 * Created on 2015/7/29.
 */

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 发现的大分类
 */
public class DiscoveryCategory implements Comparable<DiscoveryCategory>{

    private int id;
    private String name;
    private String title;
    private boolean isChecked;
    private int orderNum;
    private String coverPath;
    private boolean selectedSwitch;
    private boolean ifFinished;
    private String contentType;

    public void parseJSON(JSONObject json) throws JSONException {
        if (json != null) {
            id = json.getInt("id");
            name = json.getString("name");
            title = json.getString("title");
            isChecked = json.optBoolean("isChecked");
            orderNum = json.getInt("orderNum");
            coverPath = json.getString("coverPath");
            selectedSwitch = json.optBoolean("selectedSwitch");
            ifFinished = json.optBoolean("isFinished");
            contentType = json.getString("contentType");

        }
    }

    @Override
    public int compareTo(DiscoveryCategory another) {
        int ret = 0;

        if (another != null) {
            ret  = orderNum - another.orderNum;
        }
        return ret;
    }
}
