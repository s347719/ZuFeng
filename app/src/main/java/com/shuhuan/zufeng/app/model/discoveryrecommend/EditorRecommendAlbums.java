package com.shuhuan.zufeng.app.model.discoveryrecommend;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Project:ZuFeng
 * user:MIKE Shu
 * Email:578076417@qq.com
 * Created on 2015/7/30.
 */
public class EditorRecommendAlbums {

    private int ret;
    private String title;

    private boolean hasMore;

    private List<AlbumRecommend> list;

    public void parseJSON(JSONObject json) throws JSONException {
        Log.i("---解析小编推荐----","----");
        if (json != null) {
            title = json.getString("title");
            hasMore = json.optBoolean("hasMore");
            JSONArray array = json.optJSONArray("list");
            if (array != null) {
                int len = array.length();
                if (len > 0) {
                    list = new LinkedList<AlbumRecommend>();
                    for (int i = 0; i < len; i++) {
                        JSONObject jsonObject = array.getJSONObject(i);
                        AlbumRecommend album = new AlbumRecommend();
                        album.parseJson(jsonObject);
                        list.add(album);
                    }
                }
            }
        }
    }

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
        return "EditorRecommendAlbums{" +
                "ret=" + ret +
                ", title='" + title + '\'' +
                ", hasMore=" + hasMore +
                ", list=" + list +
                '}';
    }
}
