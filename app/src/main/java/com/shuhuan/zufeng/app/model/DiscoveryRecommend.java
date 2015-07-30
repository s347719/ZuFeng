package com.shuhuan.zufeng.app.model;


import com.shuhuan.zufeng.app.model.discoveryrecommend.*;

/**
 * Created with Intellij IDEA.
 * Project:ZuFeng
 * user:MIKE Shu
 * Email:578076417@qq.com
 * Created on 2015/7/30.
 */
public class DiscoveryRecommend {


    private DiscoveryDiscoveryColumns discoveryDiscoveryColumns;
    private DiscoveryEditorRecommendAlbums discoveryEditorRecommendAlbums;
    private DiscoveryHotRecommends discoveryHotRecommends;
    private DiscoveryFocusImages discoveryFocusImages;
    private DiscoverySpecialColumn discoverySpecialColumn;

    public void setDiscoveryDiscoveryColumns(DiscoveryDiscoveryColumns discoveryDiscoveryColumns) {
        this.discoveryDiscoveryColumns = discoveryDiscoveryColumns;
    }

    public void setDiscoveryEditorRecommendAlbums(DiscoveryEditorRecommendAlbums discoveryEditorRecommendAlbums) {
        this.discoveryEditorRecommendAlbums = discoveryEditorRecommendAlbums;
    }

    public void setDiscoveryHotRecommends(DiscoveryHotRecommends discoveryHotRecommends) {
        this.discoveryHotRecommends = discoveryHotRecommends;
    }

    public void setDiscoveryFocusImages(DiscoveryFocusImages discoveryFocusImages) {
        this.discoveryFocusImages = discoveryFocusImages;
    }

    public void setDiscoverySpecialColumn(DiscoverySpecialColumn discoverySpecialColumn) {
        this.discoverySpecialColumn = discoverySpecialColumn;
    }

    public DiscoveryDiscoveryColumns getDiscoveryDiscoveryColumns() {
        return discoveryDiscoveryColumns;
    }

    public DiscoveryEditorRecommendAlbums getDiscoveryEditorRecommendAlbums() {
        return discoveryEditorRecommendAlbums;
    }

    public DiscoveryHotRecommends getDiscoveryHotRecommends() {
        return discoveryHotRecommends;
    }

    public DiscoveryFocusImages getDiscoveryFocusImages() {
        return discoveryFocusImages;
    }

    public DiscoverySpecialColumn getDiscoverySpecialColumn() {
        return discoverySpecialColumn;
    }

    @Override
    public String toString() {
        return "DiscoveryRecommend{" +
                "discoveryDiscoveryColumns=" + discoveryDiscoveryColumns +
                ", discoveryEditorRecommendAlbums=" + discoveryEditorRecommendAlbums +
                ", discoveryHotRecommends=" + discoveryHotRecommends +
                ", discoveryFocusImages=" + discoveryFocusImages +
                ", discoverySpecialColumn=" + discoverySpecialColumn +
                '}';
    }
}
