package com.shuhuan.zufeng.app.model.discoveryrecommend.hotrecommendclickshowplayer;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created with Intellij IDEA.
 * Project:ZuFeng
 * user:MIKE Shu
 * Email:578076417@qq.com
 * Created on 2015/8/2.
 */
public class ShowPlayerData {


    private String playUrl64;
    private double duration;
    private int uid;
    private String playPathAacv224;
    private String playUrl32;
    private int trackId;
    private String downloadUrl;
    private String playPathAacv164;
    private String title;


    public void parseJson(JSONObject json) throws JSONException {
        playUrl64 = json.getString("playUrl64");
        playPathAacv224 = json.getString("playPathAacv224");
        playUrl32 = json.getString("playUrl32");
        downloadUrl = json.getString("downloadUrl");
        playPathAacv164 = json.getString("playPathAacv164");
        title = json.getString("title");

        duration = json.getDouble("duration");
        uid = json.getInt("uid");
        trackId = json.getInt("trackId");

    }

    public void setPlayUrl64(String playUrl64) {
        this.playUrl64 = playUrl64;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setPlayPathAacv224(String playPathAacv224) {
        this.playPathAacv224 = playPathAacv224;
    }

    public void setPlayUrl32(String playUrl32) {
        this.playUrl32 = playUrl32;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public void setPlayPathAacv164(String playPathAacv164) {
        this.playPathAacv164 = playPathAacv164;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlayUrl64() {
        return playUrl64;
    }

    public double getDuration() {
        return duration;
    }

    public int getUid() {
        return uid;
    }

    public String getPlayPathAacv224() {
        return playPathAacv224;
    }

    public String getPlayUrl32() {
        return playUrl32;
    }

    public int getTrackId() {
        return trackId;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public String getPlayPathAacv164() {
        return playPathAacv164;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "ShowPlayerData{" +
                "playUrl64='" + playUrl64 + '\'' +
                ", duration=" + duration +
                ", uid=" + uid +
                ", playPathAacv224='" + playPathAacv224 + '\'' +
                ", playUrl32='" + playUrl32 + '\'' +
                ", trackId=" + trackId +
                ", downloadUrl='" + downloadUrl + '\'' +
                ", playPathAacv164='" + playPathAacv164 + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
