package com.shuhuan.zufeng.app.model.discoveryrecommend;

/**
 * Created with Intellij IDEA.
 * Project:ZuFeng
 * user:MIKE Shu
 * Email:578076417@qq.com
 * Created on 2015/7/30.
 */

import org.json.JSONException;
import org.json.JSONObject;

/**
 * {
 "columnType": 1,
 "specialId": 348,
 "title": "5个如雷贯耳的脱口秀，高智商必听！",
 "subtitle": "人生不应该只有眼前的苟且，还有诗和远方！\r\n生活从来就不应该只有简单的吃饭穿衣，安身立命，人生除了温饱，还应该有另一个精神的高度，最终决定这个高度的，一定是眼界和见识，以及你碰到一个什么样的人生导师",
 "footnote": "5张专辑",
 "coverPath": "http://fdfs.xmcdn.com/group14/M04/4E/68/wKgDY1WyIl_jgde2AAG79hZ3Ml4209_mobile_small.jpg",
 "contentType": "1"
 },
 */
public class SpecialList {

    private int columnType;
    private int specialId;
    private String title;
    private String subtitle;
    private String footnote;
    private String coverPath;
    private int contentType;

    public  void parseJson(JSONObject json) throws JSONException {
        columnType = json.getInt("columnType");
        specialId = json.getInt("specialId");
        title = json.getString("title");
        subtitle = json.getString("subtitle");
        footnote = json.getString("footnote");
        coverPath = json.getString("coverPath");
        contentType = json.getInt("contentType");


    }

    public int getColumnType() {
        return columnType;
    }

    public void setColumnType(int columnType) {
        this.columnType = columnType;
    }

    public int getSpecialId() {
        return specialId;
    }

    public void setSpecialId(int specialId) {
        this.specialId = specialId;
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

    public String getFootnote() {
        return footnote;
    }

    public void setFootnote(String footnote) {
        this.footnote = footnote;
    }

    public String getCoverPath() {
        return coverPath;
    }

    public void setCoverPath(String coverPath) {
        this.coverPath = coverPath;
    }

    public int getContentType() {
        return contentType;
    }

    public void setContentType(int contentType) {
        this.contentType = contentType;
    }

    @Override
    public String toString() {
        return "SpecialList{" +
                "columnType=" + columnType +
                ", specialId=" + specialId +
                ", title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", footnote='" + footnote + '\'' +
                ", coverPath='" + coverPath + '\'' +
                ", contentType=" + contentType +
                '}';
    }
}
