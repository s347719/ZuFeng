package com.shuhuan.zufeng.app.parsers;

import android.content.Context;
import android.util.Log;
import com.shuhuan.zufeng.app.model.CategoryTagMenu;
import com.shuhuan.zufeng.app.model.DiscoveryCategory;
import com.shuhuan.zufeng.app.model.DiscoveryRecommend;
import com.shuhuan.zufeng.app.model.DiscoveryTab;
import com.shuhuan.zufeng.app.model.discoveryrecommend.*;
import com.shuhuan.zufeng.app.model.discoveryrecommend.horecommendclickshow.HotRecommendClickShow;
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
 * Created on 2015/7/28.
 */
public final class DataParser  {

    private DataParser(){}

    public static List<DiscoveryCategory> parseDiscoveryCategory(JSONObject json)
    {
        List<DiscoveryCategory> ret = null;

        if (json != null) {
            try {
                int code = json.getInt("ret");
                if (code == 0)
                {
                    JSONArray jsonArray = json.getJSONArray("list");
                    int len = jsonArray.length();
                    if (len>0)
                    {
                        ret = new LinkedList<DiscoveryCategory>();
                        for (int i = 0; i < len; i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            DiscoveryCategory category = new DiscoveryCategory();
                            category.parseJSON(jsonObject);
                            ret.add(category);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return ret;
    }

    /**
     * 解析CategoryTagMenu 返回的JSON结果
     *
     * @param json JSONObject
     * @return
     */
    public static List<CategoryTagMenu> parseCategoryTagMenu(JSONObject json)
    {
        List<CategoryTagMenu> ret = null;
        if (json != null) {
            try {
                int code =  json.getInt("ret");
                if (code ==0)
                {
                    JSONObject data = json.getJSONObject("data");
                    int category_count = data.getInt("category_count");
                    if (category_count>0)
                    {
                        JSONArray array = data.getJSONArray("category_list");
                        category_count = array.length();
                        if (category_count>0)
                        {
                            ret = new LinkedList<CategoryTagMenu>();
                            for (int i = 0; i < category_count; i++) {
                                JSONObject jsonObject = array.getJSONObject(i);

                                CategoryTagMenu menu = new CategoryTagMenu();

                                 //  实体类 自己  解析 自己的数据
                                menu.parseJSON(jsonObject);
                                ret.add(menu);

                            }
                        }
                    }
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return ret;
    }

    /**
     *
     * 解析发现的标题
     * @param jsonObject
     * @return
     */
    public static List<DiscoveryTab> parseDiscoveryTabs(JSONObject jsonObject) {

        List<DiscoveryTab> ret = null;

        try {
            int code = jsonObject.getInt("ret");
            if (code ==0)
            {
                JSONObject tabs = jsonObject.getJSONObject("tabs");
                JSONArray array = tabs.getJSONArray("list");
                if (array != null) {
                    int len = array.length();
                    if (len>0)
                    {
                        ret = new LinkedList<DiscoveryTab>();
                        for (int i = 0; i < len; i++) {
                            DiscoveryTab tab = new DiscoveryTab();
                            tab.parseJSON(array.getJSONObject(i));
                            ret.add(tab);
                        }
                    }
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return ret;
    }


    /**
     *
     * 解析发现数据结构
     * @param json 传入一个对象
     * @return  返回一个值（对象）
     */
    public static DiscoveryRecommend parseDiscoveryRecommend(JSONObject json) {

        DiscoveryRecommend ret = null;

        if (json != null) {

            try {
                int code = json.getInt("ret");

                if (code == 0){
                    ret = new DiscoveryRecommend();
                    ret.parseJSON(json);


                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        return ret;

    }

    public static HotRecommendClickShow parseDiscoveryHotRecommend(JSONObject json) {

        HotRecommendClickShow ret =null;
        if (json != null) {
            try {
                int code = json.getInt("ret");
                if (code==0)
                {
                    ret = new HotRecommendClickShow();
                    ret.parseJSON(json);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        Log.i("#########","&&经过解析的数据----"+ret);
        return  ret;

    }
}
