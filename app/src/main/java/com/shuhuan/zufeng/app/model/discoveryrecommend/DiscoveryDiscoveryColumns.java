package com.shuhuan.zufeng.app.model.discoveryrecommend;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Project:ZuFeng
 * user:MIKE Shu
 * Email:578076417@qq.com
 * Created on 2015/7/30.
 */
public class DiscoveryDiscoveryColumns {

    private int ret ;
    private String title;
    private int locationInHotRecommend;
    private List<ColumnsList> columnsList;

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

    public int getLocationInHotRecommend() {
        return locationInHotRecommend;
    }

    public void setLocationInHotRecommend(int locationInHotRecommend) {
        this.locationInHotRecommend = locationInHotRecommend;
    }

    public List<ColumnsList> getColumnsList() {
        return columnsList;
    }

    public void setColumnsList(List<ColumnsList> columnsList) {
        this.columnsList = columnsList;
    }

    @Override
    public String toString() {
        return "DiscoveryDiscoveryColumns{" +
                "ret=" + ret +
                ", title='" + title + '\'' +
                ", locationInHotRecommend=" + locationInHotRecommend +
                ", columnsList=" + columnsList +
                '}';
    }
}
