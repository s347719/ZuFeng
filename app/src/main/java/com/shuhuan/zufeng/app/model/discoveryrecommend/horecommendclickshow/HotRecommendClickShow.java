package com.shuhuan.zufeng.app.model.discoveryrecommend.horecommendclickshow;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created with Intellij IDEA.
 * Project:ZuFeng
 * user:MIKE Shu
 * Email:578076417@qq.com
 * Created on 2015/8/2.
 */
public class HotRecommendClickShow {


    private ShowAlbum showAlbum;
    private ShowTrack showTrack;


    public void parseJSON(JSONObject json){
        if (json != null) {
            try {
                JSONObject object = json.getJSONObject("album");
                showAlbum = new ShowAlbum();
                showAlbum.parseJson(object);

                JSONObject objectTracks = json.getJSONObject("tracks");
                showTrack = new ShowTrack();
                showTrack.parseJSON(objectTracks);
            }
            catch (JSONException e)
            {
                e.printStackTrace();
            }
        }



    }


    public ShowAlbum getShowAlbum() {
        return showAlbum;
    }

    public void setShowAlbum(ShowAlbum showAlbum) {
        this.showAlbum = showAlbum;
    }

    public ShowTrack getShowTrack() {
        return showTrack;
    }

    public void setShowTrack(ShowTrack showTrack) {
        this.showTrack = showTrack;
    }

    @Override
    public String toString() {
        return "HotRecommendClickShow{" +
                "showAlbum=" + showAlbum +
                ", showTrack=" + showTrack +
                '}';
    }
}
