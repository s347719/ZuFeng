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
public class ShowTracksListPlayer {


    /**
     * processState : 2
     * opType : 1
     * downloadUrl : http://download.xmcdn.com/group10/M07/52/50/wKgDaVW2elHirDiwAJ5aSy_6VKU544.aac
     * albumId : 203355
     * orderNum : 99999999
     * title : 段子来了丨飞机一日千百里，电梯一屁几十米50728（采采）
     * playUrl64 : http://fdfs.xmcdn.com/group8/M08/52/5B/wKgDYFW2envSiMSyATE0a1NxlgI220.mp3
     * duration : 2500.21
     * coverSmall : http://fdfs.xmcdn.com/group7/M07/53/26/wKgDWlW26MGQ8SKQAAFrgB20PU8213_mobile_small.jpg
     * shares : 0
     * uid : 2629577
     * playPathAacv224 : http://audio.xmcdn.com/group10/M07/52/53/wKgDZ1W2ejeTU5ytAHXCHrwQF60039.m4a
     * createdAt : 1438022270000
     * downloadAacSize : 7717406
     * nickname : 枕边疯电台
     * albumTitle : 段子来了
     * isPublic : true
     * playPathAacv164 : http://audio.xmcdn.com/group10/M07/52/51/wKgDaVW2emmhQ0h1ATSDth0VxeI658.m4a
     * coverLarge : http://fdfs.xmcdn.com/group7/M07/53/26/wKgDWlW26MGQ8SKQAAFrgB20PU8213_mobile_large.jpg
     * likes : 1126
     * comments : 695
     * trackId : 7996526
     * userSource : 1
     * playtimes : 80978
     * smallLogo : http://fdfs.xmcdn.com/group3/M00/64/F8/wKgDslJ68TnQpnVPAAU-A1zGGqI128_mobile_small.jpg
     * downloadAacUrl : http://audio.xmcdn.com/group10/M07/52/53/wKgDZ1W2ejeTU5ytAHXCHrwQF60039.m4a
     * playUrl32 : http://fdfs.xmcdn.com/group10/M07/52/53/wKgDZ1W2ekPBgmC_AJiaTKE52lI991.mp3
     * downloadSize : 10377803
     * albumImage : http://fdfs.xmcdn.com/group5/M03/A6/D8/wKgDtlR1MD_T1DQHAANqZDyk48s720_mobile_small.jpg
     * status : 1
     */
    private int processState;
    private int opType;
    private String downloadUrl;
    private int albumId;
    private int orderNum;
    private String title;
    private String playUrl64;
    private double duration;
    private String coverSmall;
    private int shares;
    private int uid;
    private String playPathAacv224;
    private long createdAt;
    private int downloadAacSize;
    private String nickname;
    private String albumTitle;
    private boolean isPublic;
    private String playPathAacv164;
    private String coverLarge;
    private int likes;
    private int comments;
    private int trackId;
    private int userSource;
    private int playtimes;
    private String smallLogo;
    private String downloadAacUrl;
    private String playUrl32;
    private int downloadSize;
    private String albumImage;
    private int status;


    public  void parseJSON(JSONObject json) throws JSONException {

        downloadUrl = json.getString("downloadUrl");
        title = json.getString("title");
        playUrl64 = json.getString("playUrl64");
        coverSmall = json.getString("coverSmall");
        playPathAacv224 = json.getString("playPathAacv224");
        nickname = json.getString("nickname");
        albumTitle = json.getString("albumTitle");
        playPathAacv164 = json.getString("playPathAacv164");
        coverLarge = json.getString("coverLarge");
        smallLogo = json.getString("smallLogo");
        downloadAacUrl = json.getString("downloadAacUrl");
        playUrl32 = json.getString("playUrl32");
        albumImage = json.getString("albumImage");



        processState = json.getInt("processState");
        opType = json.getInt("opType");
        albumId = json.getInt("albumId");
        orderNum = json.getInt("orderNum");
        shares = json.getInt("shares");
        uid = json.getInt("uid");
        downloadAacSize = json.getInt("downloadAacSize");
        likes = json.getInt("likes");
        comments = json.getInt("comments");
        trackId = json.getInt("trackId");
        downloadSize = json.getInt("downloadSize");
        status = json.getInt("status");
        createdAt = json.getLong("createdAt");
        duration = json.getDouble("duration");
        isPublic = json.getBoolean("isPublic");

    }

    public void setProcessState(int processState) {
        this.processState = processState;
    }

    public void setOpType(int opType) {
        this.opType = opType;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPlayUrl64(String playUrl64) {
        this.playUrl64 = playUrl64;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public void setCoverSmall(String coverSmall) {
        this.coverSmall = coverSmall;
    }

    public void setShares(int shares) {
        this.shares = shares;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setPlayPathAacv224(String playPathAacv224) {
        this.playPathAacv224 = playPathAacv224;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public void setDownloadAacSize(int downloadAacSize) {
        this.downloadAacSize = downloadAacSize;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    public void setIsPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }

    public void setPlayPathAacv164(String playPathAacv164) {
        this.playPathAacv164 = playPathAacv164;
    }

    public void setCoverLarge(String coverLarge) {
        this.coverLarge = coverLarge;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    public void setUserSource(int userSource) {
        this.userSource = userSource;
    }

    public void setPlaytimes(int playtimes) {
        this.playtimes = playtimes;
    }

    public void setSmallLogo(String smallLogo) {
        this.smallLogo = smallLogo;
    }

    public void setDownloadAacUrl(String downloadAacUrl) {
        this.downloadAacUrl = downloadAacUrl;
    }

    public void setPlayUrl32(String playUrl32) {
        this.playUrl32 = playUrl32;
    }

    public void setDownloadSize(int downloadSize) {
        this.downloadSize = downloadSize;
    }

    public void setAlbumImage(String albumImage) {
        this.albumImage = albumImage;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getProcessState() {
        return processState;
    }

    public int getOpType() {
        return opType;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public int getAlbumId() {
        return albumId;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public String getTitle() {
        return title;
    }

    public String getPlayUrl64() {
        return playUrl64;
    }

    public double getDuration() {
        return duration;
    }

    public String getCoverSmall() {
        return coverSmall;
    }

    public int getShares() {
        return shares;
    }

    public int getUid() {
        return uid;
    }

    public String getPlayPathAacv224() {
        return playPathAacv224;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public int getDownloadAacSize() {
        return downloadAacSize;
    }

    public String getNickname() {
        return nickname;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public boolean isIsPublic() {
        return isPublic;
    }

    public String getPlayPathAacv164() {
        return playPathAacv164;
    }

    public String getCoverLarge() {
        return coverLarge;
    }

    public int getLikes() {
        return likes;
    }

    public int getComments() {
        return comments;
    }

    public int getTrackId() {
        return trackId;
    }

    public int getUserSource() {
        return userSource;
    }

    public int getPlaytimes() {
        return playtimes;
    }

    public String getSmallLogo() {
        return smallLogo;
    }

    public String getDownloadAacUrl() {
        return downloadAacUrl;
    }

    public String getPlayUrl32() {
        return playUrl32;
    }

    public int getDownloadSize() {
        return downloadSize;
    }

    public String getAlbumImage() {
        return albumImage;
    }

    public int getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "ShowTracksListPlayer{" +
                "processState=" + processState +
                ", opType=" + opType +
                ", downloadUrl='" + downloadUrl + '\'' +
                ", albumId=" + albumId +
                ", orderNum=" + orderNum +
                ", title='" + title + '\'' +
                ", playUrl64='" + playUrl64 + '\'' +
                ", duration=" + duration +
                ", coverSmall='" + coverSmall + '\'' +
                ", shares=" + shares +
                ", uid=" + uid +
                ", playPathAacv224='" + playPathAacv224 + '\'' +
                ", createdAt=" + createdAt +
                ", downloadAacSize=" + downloadAacSize +
                ", nickname='" + nickname + '\'' +
                ", albumTitle='" + albumTitle + '\'' +
                ", isPublic=" + isPublic +
                ", playPathAacv164='" + playPathAacv164 + '\'' +
                ", coverLarge='" + coverLarge + '\'' +
                ", likes=" + likes +
                ", comments=" + comments +
                ", trackId=" + trackId +
                ", userSource=" + userSource +
                ", playtimes=" + playtimes +
                ", smallLogo='" + smallLogo + '\'' +
                ", downloadAacUrl='" + downloadAacUrl + '\'' +
                ", playUrl32='" + playUrl32 + '\'' +
                ", downloadSize=" + downloadSize +
                ", albumImage='" + albumImage + '\'' +
                ", status=" + status +
                '}';
    }
}
