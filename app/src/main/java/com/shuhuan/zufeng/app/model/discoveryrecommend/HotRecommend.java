package com.shuhuan.zufeng.app.model.discoveryrecommend;

/**
 * Created with Intellij IDEA.
 * Project:ZuFeng
 * user:MIKE Shu
 * Email:578076417@qq.com
 * Created on 2015/7/30.
 */

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

/**
 * "title": "听新闻",
 "contentType": "album",
 "isFinished": false,
 "categoryId": 1,
 "count": 822,
 "hasMore": true,
 */
public class HotRecommend {

    private String title;
    private String contentType;
    private boolean isFinished;
    private int categoryId;
    private int count;
    private boolean hasMore;
    private List<AlbumRecommend> list;

    public void parseJson(JSONObject json) throws JSONException {
        title = json.getString("title");
        contentType = json.getString("contentType");
        isFinished = json.getBoolean("isFinished");
        categoryId = json.optInt("categoryId");
        count = json.optInt("count");
        hasMore = json.getBoolean("hasMore");

        JSONArray array = json.getJSONArray("list");
        if (array != null) {
            int len = array.length();
            if (len>0)
            {
                list = new LinkedList<AlbumRecommend>();
                for (int i = 0; i < len; i++) {

                    JSONObject object = array.getJSONObject(i);
                    AlbumRecommend recommend = new AlbumRecommend();
                    recommend.parseJson(object);
                    list.add(recommend);
                }

            }
        }

    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setIsFinished(boolean isFinished) {
        this.isFinished = isFinished;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    public List<AlbumRecommend> getList() {
        return list;
    }

    public void setList(List<AlbumRecommend> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "HotRecommend{" +
                "title='" + title + '\'' +
                ", contentType='" + contentType + '\'' +
                ", isFinished=" + isFinished +
                ", categoryId=" + categoryId +
                ", count=" + count +
                ", hasMore=" + hasMore +
                ", list=" + list +
                '}';
    }
}
