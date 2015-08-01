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
public class FocusImage {


    /**
     *
     *
     * "id": 3597,
     "shortTitle": "中国每天2亿人乘电梯，安全吗？",
     "longTitle": "中国每天2亿人乘电梯，安全吗？",
     "pic": "http://fdfs.xmcdn.com/group15/M06/52/77/wKgDaFW16vfD9nFSAAHBRSk6xm4459_android_large.jpg",
     "type": 2,
     "uid": 30495264,
     "albumId": 2814299,
     "isShare": false,
     "is_External_url": false
     */
    private int uid;
    private boolean is_External_url;
    private boolean isShare;
    private int albumId;
    private int id;
    private String shortTitle;
    private String pic;
    private int type;
    private String longTitle;



    public void parseJson(JSONObject json) throws JSONException {

        uid = json.optInt("uid");
        is_External_url = json.getBoolean("is_External_url");
        isShare = json.getBoolean("isShare");
        albumId = json.optInt("albumId");
        id  =json.getInt("id");
        shortTitle = json.getString("shortTitle");
        pic = json.getString("pic");
        type = json.getInt("type");
        longTitle = json.getString("longTitle");
    }



    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setIs_External_url(boolean is_External_url) {
        this.is_External_url = is_External_url;
    }

    public void setIsShare(boolean isShare) {
        this.isShare = isShare;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setLongTitle(String longTitle) {
        this.longTitle = longTitle;
    }

    public int getUid() {
        return uid;
    }

    public boolean isIs_External_url() {
        return is_External_url;
    }

    public boolean isIsShare() {
        return isShare;
    }

    public int getAlbumId() {
        return albumId;
    }

    public int getId() {
        return id;
    }

    public String getShortTitle() {
        return shortTitle;
    }

    public String getPic() {
        return pic;
    }

    public int getType() {
        return type;
    }

    public String getLongTitle() {
        return longTitle;
    }

    @Override
    public String toString() {
        return "FocusImage{" +
                "uid=" + uid +
                ", is_External_url=" + is_External_url +
                ", isShare=" + isShare +
                ", albumId=" + albumId +
                ", id=" + id +
                ", shortTitle='" + shortTitle + '\'' +
                ", pic='" + pic + '\'' +
                ", type=" + type +
                ", longTitle='" + longTitle + '\'' +
                '}';
    }
}
