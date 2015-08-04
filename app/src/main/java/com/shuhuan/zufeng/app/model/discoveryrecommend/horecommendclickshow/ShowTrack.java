package com.shuhuan.zufeng.app.model.discoveryrecommend.horecommendclickshow;

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
 * Created on 2015/8/2.
 */
public class ShowTrack {

    private int pageId;
    private int pageSize;
    private int maxPageId;
    private int totalCount;
    private List<ShowTracksListPlayer>list ;


    public void parseJSON(JSONObject json) throws JSONException {
        if (json != null) {
            pageId= json.getInt("pageId");
            pageId= json.getInt("pageSize");
            pageId= json.getInt("maxPageId");
            pageId= json.getInt("totalCount");
            JSONArray array = json.getJSONArray("list");
            if (array != null) {
                int len = array.length();
                if (len>0)
                {
                    list = new LinkedList<ShowTracksListPlayer>();
                    for (int i = 0; i < len; i++) {
                        JSONObject object = array.getJSONObject(i);
                        ShowTracksListPlayer showTracksListPlayer = new ShowTracksListPlayer();
                        showTracksListPlayer.parseJSON(object);
                        list.add(showTracksListPlayer);
                    }
                }
            }

        }
    }

    public int getPageId() {
        return pageId;
    }

    public void setPageId(int pageId) {
        this.pageId = pageId;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getMaxPageId() {
        return maxPageId;
    }

    public void setMaxPageId(int maxPageId) {
        this.maxPageId = maxPageId;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<ShowTracksListPlayer> getList() {
        return list;
    }

    public void setList(List<ShowTracksListPlayer> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "ShowTrack{" +
                "pageId=" + pageId +
                ", pageSize=" + pageSize +
                ", maxPageId=" + maxPageId +
                ", totalCount=" + totalCount +
                ", list=" + list +
                '}';
    }
}
