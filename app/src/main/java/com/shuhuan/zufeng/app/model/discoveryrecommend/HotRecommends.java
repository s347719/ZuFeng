package com.shuhuan.zufeng.app.model.discoveryrecommend;

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
public class HotRecommends {

    private int ret;
    private String title;
    private List<HotRecommend> list;

    public void parseJSON(JSONObject json) throws JSONException {
        if (json != null) {
            title = json.getString("title");
            JSONArray array = json.optJSONArray("list");
            if (array != null) {
                int len = array.length();
                if (len > 0) {
                    list = new LinkedList<HotRecommend>();

                    for (int i = 0; i < len; i++) {
                        JSONObject object = array.getJSONObject(i);
                        HotRecommend recommend = new HotRecommend();
                        recommend.parseJson(object);
                        list.add(recommend);
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

    public List<HotRecommend> getList() {
        return list;
    }

    public void setList(List<HotRecommend> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "HotRecommends{" +
                "ret=" + ret +
                ", title='" + title + '\'' +
                ", list=" + list +
                '}';
    }
}
