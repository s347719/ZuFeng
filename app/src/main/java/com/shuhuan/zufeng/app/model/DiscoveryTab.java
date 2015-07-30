package com.shuhuan.zufeng.app.model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created with Intellij IDEA.
 * Project:ZuFeng
 * user:MIKE Shu
 * Email:578076417@qq.com
 * Created on 2015/7/29.
 */
public class    DiscoveryTab  {
    /**
     * 显示DiscoveryFragment
     * 上面的Tab 标题
     */
    private String title;

    /**
     * 内容的描述，代码判断的时候用的
     */
    private String contentType;

    public void parseJSON(JSONObject json) throws JSONException {
        if (json != null) {
            title = json.getString("title");
            contentType = json.getString("contentType");
        }
    }

    public String getTitle() {
        return title;
    }

    public String getContentType() {
        return contentType;
    }
}
