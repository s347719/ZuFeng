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
public class Sprint {

    private int id;

    private int orderNum;

    private String title;

    private String subtitle;

    private String coverPath;

    private String contentType;

    private String url;

    private String sharePic;

    private boolean enableShare;

    private long contentUpdatedAt;

    private boolean isHot;

    private boolean isExternalUrl;

    public void parseJSON(JSONObject json) throws JSONException {
        if (json != null) {

            id = json.getInt("id");
            orderNum = json.getInt("orderNum");
            title = json.getString("title");
            subtitle = json.getString("subtitle");
            coverPath = json.getString("coverPath");
            contentType = json.getString("contentType");
            url = json.getString("url");
            sharePic = json.getString("sharePic");
            enableShare = json.getBoolean("enableShare");
            contentUpdatedAt = json.getLong("contentUpdatedAt");
            isHot = json.optBoolean("isHot");
            isExternalUrl = json.optBoolean("isExternalUrl");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getCoverPath() {
        return coverPath;
    }

    public void setCoverPath(String coverPath) {
        this.coverPath = coverPath;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSharePic() {
        return sharePic;
    }

    public void setSharePic(String sharePic) {
        this.sharePic = sharePic;
    }

    public boolean isEnableShare() {
        return enableShare;
    }

    public void setEnableShare(boolean enableShare) {
        this.enableShare = enableShare;
    }

    public long getContentUpdatedAt() {
        return contentUpdatedAt;
    }

    public void setContentUpdatedAt(long contentUpdatedAt) {
        this.contentUpdatedAt = contentUpdatedAt;
    }

    public boolean isHot() {
        return isHot;
    }

    public void setIsHot(boolean isHot) {
        this.isHot = isHot;
    }

    public boolean isExternalUrl() {
        return isExternalUrl;
    }

    public void setIsExternalUrl(boolean isExternalUrl) {
        this.isExternalUrl = isExternalUrl;
    }

    @Override
    public String toString() {
        return "Sprint{" +
                "id=" + id +
                ", orderNum=" + orderNum +
                ", title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", coverPath='" + coverPath + '\'' +
                ", contentType='" + contentType + '\'' +
                ", url='" + url + '\'' +
                ", sharePic='" + sharePic + '\'' +
                ", enableShare=" + enableShare +
                ", contentUpdatedAt=" + contentUpdatedAt +
                ", isHot=" + isHot +
                ", isExternalUrl=" + isExternalUrl +
                '}';
    }
}
