package com.shuhuan.zufeng.app.model.discoveryrecommend.hotrecommendclickshowplayer;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created with Intellij IDEA.
 * Project:ZuFeng
 * user:MIKE Shu
 * Email:578076417@qq.com
 * Created on 2015/8/4.
 */
public class ClickShow {

    private ShowPlayerData showPlayerData;
    public void parseJson(JSONObject json){

        if (json != null) {
            try {
                JSONObject object = json.getJSONObject("data");
                showPlayerData = new ShowPlayerData();
                showPlayerData.parseJson(object);


            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }

    public ShowPlayerData getShowPlayerData() {
        return showPlayerData;
    }

    public void setShowPlayerData(ShowPlayerData showPlayerData) {
        this.showPlayerData = showPlayerData;
    }


    @Override
    public String toString() {
        return "ClickShow{" +
                "showPlayerData=" + showPlayerData +
                '}';
    }
}
