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
public class ShowAlbum {


    /**
     * serializeStatus : 0
     * hasNew : false
     * coverOrigin : http://fdfs.xmcdn.com/group5/M03/A6/D8/wKgDtlR1MD_T1DQHAANqZDyk48s720.jpg
     * isVerified : true
     * playTimes : 142941681
     * avatarPath : http://fdfs.xmcdn.com/group3/M00/64/F8/wKgDslJ68TnQpnVPAAU-A1zGGqI128_mobile_small.jpg
     * albumId : 203355
     * title : 段子来了
     * categoryName : 综艺娱乐
     * tracks : 302
     * tags : 段子来了,脱口秀,采采,搞笑,笑话
     * coverSmall : http://fdfs.xmcdn.com/group5/M03/A6/D8/wKgDtlR1MD_T1DQHAANqZDyk48s720_mobile_small.jpg
     * shares : 0
     * createdAt : 1376650745000
     * uid : 2629577
     * intro : 更多请关注微信公众账号： caicaifm
     * nickname : 枕边疯电台   //  需要取到
     * introRich : 更多请关注微信公众账号： caicaifm
     * coverLarge : http://fdfs.xmcdn.com/group5/M03/A6/D8/wKgDtlR1MD_T1DQHAANqZDyk48s720_mobile_large.jpg
     * coverWebLarge : http://fdfs.xmcdn.com/group5/M03/A6/D8/wKgDtlR1MD_T1DQHAANqZDyk48s720_web_large.jpg
     * categoryId : 4
     * updatedAt : 1435591762000
     * isFavorite : false
     * status : 1
     */
    private int serializeStatus;
    private boolean hasNew;
    private String coverOrigin;
    private boolean isVerified;
    private int playTimes;
    private String avatarPath;
    private int albumId;
    private String title;
    private String categoryName;
    private int tracks;
    private String tags;
    private String coverSmall;
    private int shares;
    private long createdAt;
    private int uid;
    private String intro;
    private String nickname;
    private String introRich;
    private String coverLarge;
    private String coverWebLarge;
    private int categoryId;
    private long updatedAt;
    private boolean isFavorite;
    private int status;


    public void parseJson(JSONObject json) throws JSONException {
        serializeStatus = json.getInt("serializeStatus");
        hasNew = json.getBoolean("hasNew");
        coverOrigin = json.getString("coverOrigin");
        isVerified = json.getBoolean("isVerified");
        playTimes = json.optInt("playTimes");
        avatarPath = json.getString("avatarPath");
        albumId = json.getInt("albumId");
        title = json.getString("title");
        categoryName = json.getString("categoryName");
        tracks =json.getInt("tracks");
        coverSmall = json.getString("coverSmall");
        shares = json.getInt("shares");
        createdAt = json.getLong("createdAt");
        uid = json.getInt("uid");
        intro = json.getString("intro");
        nickname = json.getString("nickname");
        introRich = json.getString("introRich");
        coverLarge = json.getString("coverLarge");
        coverWebLarge = json.getString("coverWebLarge");
        categoryId = json.getInt("categoryId");
        updatedAt = json.getLong("updatedAt");
        isFavorite = json.getBoolean("isFavorite");
        status = json.getInt("status");


    }

    public void setSerializeStatus(int serializeStatus) {
        this.serializeStatus = serializeStatus;
    }

    public void setHasNew(boolean hasNew) {
        this.hasNew = hasNew;
    }

    public void setCoverOrigin(String coverOrigin) {
        this.coverOrigin = coverOrigin;
    }

    public void setIsVerified(boolean isVerified) {
        this.isVerified = isVerified;
    }

    public void setPlayTimes(int playTimes) {
        this.playTimes = playTimes;
    }

    public void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setTracks(int tracks) {
        this.tracks = tracks;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public void setCoverSmall(String coverSmall) {
        this.coverSmall = coverSmall;
    }

    public void setShares(int shares) {
        this.shares = shares;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setIntroRich(String introRich) {
        this.introRich = introRich;
    }

    public void setCoverLarge(String coverLarge) {
        this.coverLarge = coverLarge;
    }

    public void setCoverWebLarge(String coverWebLarge) {
        this.coverWebLarge = coverWebLarge;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setIsFavorite(boolean isFavorite) {
        this.isFavorite = isFavorite;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getSerializeStatus() {
        return serializeStatus;
    }

    public boolean isHasNew() {
        return hasNew;
    }

    public String getCoverOrigin() {
        return coverOrigin;
    }

    public boolean isIsVerified() {
        return isVerified;
    }

    public int getPlayTimes() {
        return playTimes;
    }

    public String getAvatarPath() {
        return avatarPath;
    }

    public int getAlbumId() {
        return albumId;
    }

    public String getTitle() {
        return title;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public int getTracks() {
        return tracks;
    }

    public String getTags() {
        return tags;
    }

    public String getCoverSmall() {
        return coverSmall;
    }

    public int getShares() {
        return shares;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public int getUid() {
        return uid;
    }

    public String getIntro() {
        return intro;
    }

    public String getNickname() {
        return nickname;
    }

    public String getIntroRich() {
        return introRich;
    }

    public String getCoverLarge() {
        return coverLarge;
    }

    public String getCoverWebLarge() {
        return coverWebLarge;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public boolean isIsFavorite() {
        return isFavorite;
    }

    public int getStatus() {
        return status;
    }


}
