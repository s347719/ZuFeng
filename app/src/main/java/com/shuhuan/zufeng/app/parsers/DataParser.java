package com.shuhuan.zufeng.app.parsers;

import android.content.Context;
import com.shuhuan.zufeng.app.model.CategoryTagMenu;
import com.shuhuan.zufeng.app.model.DiscoveryCategory;
import com.shuhuan.zufeng.app.model.DiscoveryRecommend;
import com.shuhuan.zufeng.app.model.DiscoveryTab;
import com.shuhuan.zufeng.app.model.discoveryrecommend.*;
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

    private Context context;
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

    public static DiscoveryRecommend parseDiscoveryRecommend(JSONObject jsonObject) {


        DiscoveryRecommend discoveryRecommend = new DiscoveryRecommend();

        try {
            int code = jsonObject.getInt("ret");
            String msg = jsonObject.getString("msg");
            if (code==0 &&msg.equals("成功")) {


                ////////////////////////////////

                //TODO  解析   discoveryColumns
                JSONObject discoveryDiscoveryColumns = jsonObject.getJSONObject("discoveryColumns");

                int code1 = discoveryDiscoveryColumns.getInt("ret");
                if (code1==0)
                {
                    String title = discoveryDiscoveryColumns.getString("title");
                    int locationInHotRecommend = discoveryDiscoveryColumns.getInt("locationInHotRecommend");

                    List<ColumnsList> list  = new LinkedList<ColumnsList>();
                    if (title != null && locationInHotRecommend ==0) {
                        JSONArray array = discoveryDiscoveryColumns.getJSONArray("list");
                        for (int i = 0; i < array.length(); i++) {
                            JSONObject jsonObject1 = array.getJSONObject(i);
                            ColumnsList columnsList = new ColumnsList();
                            columnsList.parseJson(jsonObject1);
                            list.add(columnsList);
                        }
                    }

                    DiscoveryDiscoveryColumns discoveryDiscoveryColumns1 = new DiscoveryDiscoveryColumns();
                    discoveryDiscoveryColumns1.setRet(code1);
                    discoveryDiscoveryColumns1.setTitle(title);
                    discoveryDiscoveryColumns1.setLocationInHotRecommend(locationInHotRecommend);
                    discoveryDiscoveryColumns1.setColumnsList(list);
                    discoveryRecommend.setDiscoveryDiscoveryColumns(discoveryDiscoveryColumns1);
                }

                //////////////////////////////////////////////////////////////

                //  TODO   解析   discoveryEditorRecommendAlbums
                JSONObject discoveryEditorRecommendAlbums = jsonObject.getJSONObject("editorRecommendAlbums");

                int code2 = discoveryEditorRecommendAlbums.getInt("ret");
                if (code2 ==0)
                {
                    String title = discoveryEditorRecommendAlbums.getString("title");
                    boolean hasMore = discoveryEditorRecommendAlbums.getBoolean("hasMore");
                    List<AlbumList> listAlbum = new LinkedList<AlbumList>();
                    if (title!=null && hasMore)
                    {
                        JSONArray arrayAlbum = discoveryEditorRecommendAlbums.getJSONArray("list");
                        for (int i = 0; i < arrayAlbum.length(); i++) {
                            JSONObject jsonObjectAlbum = arrayAlbum.getJSONObject(i);
                            AlbumList albumList = new AlbumList();
                            albumList.parseJson(jsonObjectAlbum);
                            listAlbum.add(albumList);
                        }
                    }
                    DiscoveryEditorRecommendAlbums discoveryEditorRecommendAlbums1=
                            new DiscoveryEditorRecommendAlbums();
                    discoveryEditorRecommendAlbums1.setRet(code2);
                    discoveryEditorRecommendAlbums1.setTitle(title);
                    discoveryEditorRecommendAlbums1.setHasMore(hasMore);
                    discoveryEditorRecommendAlbums1.setList(listAlbum);
                    discoveryRecommend.setDiscoveryEditorRecommendAlbums(discoveryEditorRecommendAlbums1);
                 }

                ///////////////////////////////////////////////////////////////

                JSONObject discoveryHotRecommends = jsonObject.getJSONObject("hotRecommends");

                int code3 = discoveryHotRecommends.getInt("ret");
                if (code3==0)
                {
                    String title = discoveryHotRecommends.getString("title");

                    List<HotRecommendFirstList> list = new LinkedList<HotRecommendFirstList>();
                    if (title!=null)
                    {
                        JSONArray listHotRecommend = discoveryHotRecommends.getJSONArray("list");
                        for (int i = 0; i < listHotRecommend.length(); i++) {
                            JSONObject listHotRecommendJSONObject = listHotRecommend.getJSONObject(i);
                            HotRecommendFirstList hotRecommendFirstList = new HotRecommendFirstList();
                            hotRecommendFirstList.parseJson(listHotRecommendJSONObject);
                            list.add(hotRecommendFirstList);
                        }
                    }

                    DiscoveryHotRecommends discoveryHotRecommends1 = new DiscoveryHotRecommends();
                    discoveryHotRecommends1.setRet(code3);
                    discoveryHotRecommends1.setTitle(title);
                    discoveryHotRecommends1.setList(list);
                    discoveryRecommend.setDiscoveryHotRecommends(discoveryHotRecommends1);
                }


/////////////////////////////////////////////////////////////////////
                JSONObject discoveryFocusImages = jsonObject.getJSONObject("focusImages");

                int code4 = discoveryFocusImages.getInt("ret");
                List<FocusImage> listFocus = new LinkedList<FocusImage>();
                if (code4==0 ) {
                    String title = discoveryFocusImages.getString("title");
                    if (title != null) {
                        JSONArray array = discoveryFocusImages.getJSONArray("list");
                        for (int i = 0; i < array.length(); i++) {
                            JSONObject object = array.getJSONObject(i);
                            FocusImage focusImage = new FocusImage();
                            focusImage.parseJson(object);
                            listFocus.add(focusImage);
                        }
                    }

                    DiscoveryFocusImages discoveryFocusImages1 = new DiscoveryFocusImages();
                    discoveryFocusImages1.setRet(code4);
                    discoveryFocusImages1.setTitle(title);
                    discoveryFocusImages1.setList(listFocus);
                    discoveryRecommend.setDiscoveryFocusImages(discoveryFocusImages1);

                }
                ///////////////////////////////////////////////////////////////////////////

                JSONObject discoverySpecialColumn = jsonObject.getJSONObject("specialColumn");

                int code5 = discoverySpecialColumn.getInt("ret");
                List<SpecialList> listSpecial = new LinkedList<SpecialList>();
                if (code5==0)
                {
                    String title  = discoverySpecialColumn.getString("title");
                    if (title!=null)
                    {
                        boolean hasMore = discoverySpecialColumn.getBoolean("hasMore");
                        if(hasMore)
                        {
                            JSONArray arraySpecial = discoverySpecialColumn.getJSONArray("list");

                            for (int i = 0; i < arraySpecial.length(); i++) {
                                JSONObject arraySpecialJSONObject = arraySpecial.getJSONObject(i);
                                SpecialList specialList = new SpecialList();
                                specialList.parseJson(arraySpecialJSONObject);
                                listSpecial.add(specialList);
                            }

                        }
                    }
                    DiscoverySpecialColumn discoverySpecialColumn1 = new DiscoverySpecialColumn();
                    discoverySpecialColumn1.setRet(code5);
                    discoverySpecialColumn1.setTitle(title);
                    discoverySpecialColumn1.setList(listSpecial);
                    discoveryRecommend.setDiscoverySpecialColumn(discoverySpecialColumn1);
                }



            }
            else
            {
                //  TODO  解析失败
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


        return discoveryRecommend;
    }
}
