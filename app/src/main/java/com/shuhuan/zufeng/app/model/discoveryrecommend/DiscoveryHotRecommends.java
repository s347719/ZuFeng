package com.shuhuan.zufeng.app.model.discoveryrecommend;

import java.util.List;

/**
 * Created with Intellij IDEA.
 * Project:ZuFeng
 * user:MIKE Shu
 * Email:578076417@qq.com
 * Created on 2015/7/30.
 */
public class DiscoveryHotRecommends {

    private int ret;
    private String title;
    private List<HotRecommendFirstList> list;

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

    public List<HotRecommendFirstList> getList() {
        return list;
    }

    public void setList(List<HotRecommendFirstList> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "DiscoveryHotRecommends{" +
                "ret=" + ret +
                ", title='" + title + '\'' +
                ", list=" + list +
                '}';
    }
}
