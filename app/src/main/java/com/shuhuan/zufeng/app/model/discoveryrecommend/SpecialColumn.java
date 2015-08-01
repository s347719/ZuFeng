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
public class SpecialColumn {

    private int ret;
    private String title;
    private boolean hasMore;
    private List<SpecialList> list;


    public void parseJSON(JSONObject object) throws JSONException {

        if (object != null) {
            title = object.getString("title");
            hasMore = object.getBoolean("hasMore");
            JSONArray array = object.getJSONArray("list");
            if (array != null) {
                int len  = array.length();
                if (len>0)
                {
                    list = new LinkedList<SpecialList>();
                    for (int i = 0; i < len; i++) {
                        JSONObject jsonObject = array.getJSONObject(i);
                        SpecialList specialList = new SpecialList();
                        specialList.parseJson(jsonObject);
                        list.add(specialList);
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

    public List<SpecialList> getList() {
        return list;
    }

    public void setList(List<SpecialList> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "SpecialColumn{" +
                "ret=" + ret +
                ", title='" + title + '\'' +
                ", hasMore=" + hasMore +
                ", list=" + list +
                '}';
    }


}
