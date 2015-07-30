package com.shuhuan.zufeng.app.model.discoveryrecommend;

import java.util.List;

/**
 * Created with Intellij IDEA.
 * Project:ZuFeng
 * user:MIKE Shu
 * Email:578076417@qq.com
 * Created on 2015/7/30.
 */
public class DiscoveryEditorRecommendAlbums {

    private int ret;
    private String title;
    private boolean hasMore;
    private List<AlbumList> list;

    public int getRet() {
        return ret;
    }

    public String getTitle() {
        return title;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public List<AlbumList> getList() {
        return list;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    public void setList(List<AlbumList> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "DiscoveryEditorRecommendAlbums{" +
                "ret=" + ret +
                ", title='" + title + '\'' +
                ", hasMore=" + hasMore +
                ", list=" + list +
                '}';
    }
}
