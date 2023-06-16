package com.axel.lewebservice;

import com.google.gson.annotations.SerializedName;

public class TVShow {

    @SerializedName("name")
    private String name;

    @SerializedName("network")
    private String netWork;

    @SerializedName("image_thumbnail_path")
    private String imageUrl;

    public TVShow(String name, String netWork, String imageUrl) {
        this.name = name;
        this.netWork = netWork;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNetWork() {
        return netWork;
    }

    public void setNetWork(String netWork) {
        this.netWork = netWork;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
