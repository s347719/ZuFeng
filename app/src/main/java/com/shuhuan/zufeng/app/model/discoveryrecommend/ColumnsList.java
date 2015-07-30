package com.shuhuan.zufeng.app.model.discoveryrecommend;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created with Intellij IDEA.
 * Project:ZuFeng
 * user:MIKE Shu
 * Email:578076417@qq.com
 * Created on 2015/7/30.
 */
public class ColumnsList {

    /**
     * "id": 1,
     "orderNum": 2,
     "title": "听友圈子",
     "subtitle": "给你获得一种超能力的机会，你选择什么超能力？",
     "coverPath": "http://fdfs.xmcdn.com/group9/M07/1C/8C/wKgDYlV3rd2zGc9PAAAgRAu1VLU052.png",
     "contentType": "xzone",
     "url": "",
     "sharePic": "",
     "enableShare": false,
     "contentUpdatedAt": 0
     */
    private int id;
    private int orderNum;
    private String title;
    private String subtitle;
    private String coverPath;
    private String contentType;
    private String url;
    private String sharePic;
    private boolean enableShare;
    private int contentUpdateAt;

    public  void parseJson(JSONObject json) throws JSONException {
        id = json.getInt("id");
        orderNum = json.getInt("orderNum");
        title = json.getString("title");
        subtitle = json.getString("subtitle");
        coverPath = json.getString("coverPath");
        contentType = json.getString("contentType");
        url = json.getString("url");
        sharePic = json.getString("sharePic");
        enableShare = json.getBoolean("enableShare");
        contentUpdateAt = json.getInt("contentUpdateAt");

    }

    public int getContentUpdateAt() {
        return contentUpdateAt;
    }

    public int getId() {
        return id;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getCoverPath() {
        return coverPath;
    }

    public String getContentType() {
        return contentType;
    }

    public String getUrl() {
        return url;
    }

    public String getSharePic() {
        return sharePic;
    }

    public boolean isEnableShare() {
        return enableShare;
    }

    @Override
    public String toString() {
        return "ColumnsList{" +
                "id=" + id +
                ", orderNum=" + orderNum +
                ", title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", coverPath='" + coverPath + '\'' +
                ", contentType='" + contentType + '\'' +
                ", url='" + url + '\'' +
                ", sharePic='" + sharePic + '\'' +
                ", enableShare=" + enableShare +
                ", contentUpdateAt=" + contentUpdateAt +
                '}';
    }
}
