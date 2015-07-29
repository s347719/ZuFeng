package com.shuhuan.zufeng.app.model;

/**
 * Created with Intellij IDEA.
 * Project:ZuFeng
 * user:MIKE Shu
 * Email:578076417@qq.com
 * Created on 2015/7/28.
 */

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

/**
 * 分类与Tag集合，一个分类包含了多个Tag
 */
public class CategoryTagMenu {
    private int id;
    private String name;
    private String title;
    private String intro;
    /**
     * 对应 is_display
     */
    private boolean display;

    private String coverPath;

    private List<String> tagList;

    /**
     *
     * 所有的实体类都会包含这个名称的方法，用于解析JSON
     * @param jsonObject
     */
    public void parseJSON(JSONObject jsonObject) throws JSONException {

        if (jsonObject != null) {
            id  = jsonObject.getInt("id");
            name = jsonObject.getString("name");
            title = jsonObject.getString("title");
            intro = jsonObject.optString("intro");
            display = jsonObject.getBoolean("is_desplay");
            coverPath = jsonObject.getString("cover_path");
            JSONArray array = jsonObject.optJSONArray("tag_list");
            if (array != null) {
                int len = array.length();
                tagList = new LinkedList<String>();
                for (int i = 0; i < len; i++) {
                    //逐个读取添加到taglist中  可以实现实时的变化
                    tagList.add(array.getString(i));

                }
            }
        }

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getIntro() {
        return intro;
    }

    public boolean isDisplay() {
        return display;
    }

    public String getCoverPath() {
        return coverPath;
    }


    public List<String> getTagList() {
        return tagList;
    }
}
