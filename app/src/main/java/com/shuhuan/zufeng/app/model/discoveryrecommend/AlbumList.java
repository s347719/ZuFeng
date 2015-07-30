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
public class AlbumList {


    /**
     * trackId : 7898099
     * albumId : 344497
     * playsCounts : 917714
     * coverLarge : http://fdfs.xmcdn.com/group6/M02/35/45/wKgDhFTg4w_SDkc9AAT-fXngGBY184_mobile_large.jpg
     * title : 黑先生在麦田咖啡馆
     * isFinished : 0
     * tracks : 117
     * trackTitle : 几米：音乐与绘本的美好邂逅
     * tags : 民谣,80后,文艺
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
        coverLarge= json.getString("coverLarge");
        title = json.getString("title");
        isFinished = json.getInt("isFinished");
        tracks = json.getInt("tracks");
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
        return "AlbumList{" +
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
