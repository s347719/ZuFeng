package com.shuhuan.zufeng.app.model.discoveryrecommend;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created with Intellij IDEA.
 * Project:ZuFeng
 * user:MIKE Shu
 * Email:578076417@qq.com
 * Created on 2015/7/30.
 */
public class AlbumRecommend {


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
    private int albumId;

    private String coverLarge;

    private String title;

    private String tags;

    private int tracks;

    private int playsCounts;

    private int isFinished;

    private int trackId;

    private String trackTitle;
    public void parseJson(JSONObject json) throws JSONException {
        Log.i("---小编推荐底层","---");
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


    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public String getCoverLarge() {
        return coverLarge;
    }

    public void setCoverLarge(String coverLarge) {
        this.coverLarge = coverLarge;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public int getTracks() {
        return tracks;
    }

    public void setTracks(int tracks) {
        this.tracks = tracks;
    }

    public int getPlaysCounts() {
        return playsCounts;
    }

    public void setPlaysCounts(int playsCounts) {
        this.playsCounts = playsCounts;
    }

    public int getIsFinished() {
        return isFinished;
    }

    public void setIsFinished(int isFinished) {
        this.isFinished = isFinished;
    }

    public int getTrackId() {
        return trackId;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    public String getTrackTitle() {
        return trackTitle;
    }

    public void setTrackTitle(String trackTitle) {
        this.trackTitle = trackTitle;
    }

    @Override
    public String toString() {
        return "AlbumRecommend{" +
                "albumId=" + albumId +
                ", coverLarge='" + coverLarge + '\'' +
                ", title='" + title + '\'' +
                ", tags='" + tags + '\'' +
                ", tracks=" + tracks +
                ", playsCounts=" + playsCounts +
                ", isFinished=" + isFinished +
                ", trackId=" + trackId +
                ", trackTitle='" + trackTitle + '\'' +
                '}';
    }
}
