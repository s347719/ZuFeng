package com.shuhuan.zufeng.app.model.discoveryrecommend;

import java.util.List;

/**
 * Created with Intellij IDEA.
 * Project:ZuFeng
 * user:MIKE Shu
 * Email:578076417@qq.com
 * Created on 2015/7/30.
 */
public class DiscoverySpecialColumn {

    private int ret;
    private String title;
    private boolean hasMore;
    private List<SpecialList> list;


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
        return "DiscoverySpecialColumn{" +
                "ret=" + ret +
                ", title='" + title + '\'' +
                ", hasMore=" + hasMore +
                ", list=" + list +
                '}';
    }
}
