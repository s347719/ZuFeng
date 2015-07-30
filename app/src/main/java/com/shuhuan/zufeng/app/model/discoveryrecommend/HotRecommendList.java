package com.shuhuan.zufeng.app.model.discoveryrecommend;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created with Intellij IDEA.
 * Project:ZuFeng
 * user:MIKE Shu
 * Email:578076417@qq.com
 * Created on 2015/7/30.
 */
public class HotRecommendList {


    /**
     * trackId : 7991015
     * albumId : 343042
     * playsCounts : 100781
     * coverLarge : http://fdfs.xmcdn.com/group6/M0A/E0/7E/wKgDhFUc5qbjBmDbAAAps8N-LbI468_mobile_large.jpg
     * title : 重点关注
     * isFinished : 0
     * tracks : 572
     * trackTitle : “电梯吃人”事故,谁来负责？
     * tags : 东广新闻台
     */
    private int trackId;
    private int albumId;
    private int playsCounts;
    private String coverLarge;
    private String title;
    private int isFinished;
    private int tracks;
    private String trackTitle;
    private String tags;

    public void parseJson(JSONObject json) throws JSONException {
        trackId = json.getInt("trackId");
        albumId = json.getInt("albumId");
        playsCounts = json.getInt("playsCounts");
        coverLarge = json.getString("coverLarge");
        title = json.getString("title");
        isFinished = json.getInt("isFinished");
        tracks= json.getInt("tracks");
        trackTitle = json.getString("trackTitle");
        tags = json.getString("tags");
    }



    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public void setPlaysCounts(int playsCounts) {
        this.playsCounts = playsCounts;
    }

    public void setCoverLarge(String coverLarge) {
        this.coverLarge = coverLarge;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIsFinished(int isFinished) {
        this.isFinished = isFinished;
    }

    public void setTracks(int tracks) {
        this.tracks = tracks;
    }

    public void setTrackTitle(String trackTitle) {
        this.trackTitle = trackTitle;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public int getTrackId() {
        return trackId;
    }

    public int getAlbumId() {
        return albumId;
    }

    public int getPlaysCounts() {
        return playsCounts;
    }

    public String getCoverLarge() {
        return coverLarge;
    }

    public String getTitle() {
        return title;
    }

    public int getIsFinished() {
        return isFinished;
    }

    public int getTracks() {
        return tracks;
    }

    public String getTrackTitle() {
        return trackTitle;
    }

    public String getTags() {
        return tags;
    }

    @Override
    public String toString() {
        return "HotRecommendList{" +
                "trackId=" + trackId +
                ", albumId=" + albumId +
                ", playsCounts=" + playsCounts +
                ", coverLarge='" + coverLarge + '\'' +
                ", title='" + title + '\'' +
                ", isFinished=" + isFinished +
                ", tracks=" + tracks +
                ", trackTitle='" + trackTitle + '\'' +
                ", tags='" + tags + '\'' +
                '}';
    }
}
