package com.shuhuan.zufeng.app.data;

/**
 * Created with Intellij IDEA.
 * Project:ZuFeng
 * user:MIKE Shu
 * Email:578076417@qq.com
 * Created on 2015/7/29.
 */

import com.shuhuan.zufeng.app.model.DiscoveryCategory;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * 公共的数据存储区
 *
 */
public class DataStore
{
    private static DataStore ourInstance;


    public static DataStore getInstance() {

        if (ourInstance == null) {
            ourInstance = new DataStore();
        }
        return ourInstance;
    }

    public static void release()

    {
        ourInstance = null;
    }


    private List<DiscoveryCategory> discoveryCategories;

    private DataStore() {

        discoveryCategories = new LinkedList<DiscoveryCategory>();
    }

    public void setDiscoveryCategories(List<DiscoveryCategory> categories)
    {
        if (categories != null&& !categories.isEmpty()) {
            discoveryCategories.clear();
            discoveryCategories.addAll(categories);
            Collections.sort(discoveryCategories);
        }
    }

    /**
     * 获取已经加载过的分类列表
     * @return
     */
    public List<DiscoveryCategory> getDiscoveryCategories()
    {

         return null;
    }

}
