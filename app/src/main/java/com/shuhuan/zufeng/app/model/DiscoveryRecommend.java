package com.shuhuan.zufeng.app.model;


import android.util.Log;
import com.shuhuan.zufeng.app.model.discoveryrecommend.*;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created with Intellij IDEA.
 * Project:ZuFeng
 * user:MIKE Shu
 * Email:578076417@qq.com
 * Created on 2015/7/30.
 */
public class DiscoveryRecommend {


    private EditorRecommendAlbums editorRecommendAlbums;
    private SpecialColumn specialColumn;
    private DiscoverColumns discoverColumns;
    private HotRecommends hotRecommends;


    public void parseJSON(JSONObject json) {
//        Log.i("----1111----","222222");
        if (json != null) {
            try {

                JSONObject object = json.getJSONObject("editorRecommendAlbums");
                editorRecommendAlbums = new EditorRecommendAlbums();
                editorRecommendAlbums.parseJSON(object);

                JSONObject objectSpecial = json.getJSONObject("specialColumn");
                specialColumn = new SpecialColumn();
                specialColumn.parseJSON(objectSpecial);

                JSONObject  objectColumns = json.getJSONObject("discoveryColumns");
                discoverColumns = new DiscoverColumns();
                discoverColumns.parseJSON(objectColumns);

                JSONObject  objectRecommend= json.getJSONObject("hotRecommends");
                hotRecommends = new HotRecommends();
                hotRecommends.parseJSON(objectRecommend);


            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }


    public void setDiscoverColumns(DiscoverColumns discoverColumns) {
        this.discoverColumns = discoverColumns;
    }

    public void setEditorRecommendAlbums(EditorRecommendAlbums editorRecommendAlbums) {
        this.editorRecommendAlbums = editorRecommendAlbums;
    }

    public void setHotRecommends(HotRecommends hotRecommends) {
        this.hotRecommends = hotRecommends;
    }



    public void setSpecialColumn(SpecialColumn specialColumn) {
        this.specialColumn = specialColumn;
    }

    public DiscoverColumns getDiscoverColumns() {
        return discoverColumns;
    }

    public EditorRecommendAlbums getEditorRecommendAlbums() {
        return editorRecommendAlbums;
    }

    public HotRecommends getHotRecommends() {
        return hotRecommends;
    }


    public SpecialColumn getSpecialColumn() {
        return specialColumn;
    }

    @Override
    public String toString() {
        return "DiscoveryRecommend{" +
                "discoverColumns=" + discoverColumns +
                ", editorRecommendAlbums=" + editorRecommendAlbums +
                ", hotRecommends=" + hotRecommends +
                ", specialColumn=" + specialColumn +
                '}';
    }

}
