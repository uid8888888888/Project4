package com.cskaoyan.filmmodule14;

import java.io.Serializable;

public class Banner implements Serializable {
    private static final long serialVersionUID = -4021229933238143615L;
    private int bannerId;

    private String bannerAddress;

    private String bannerUrl;

    public int getBannerId() {
        return bannerId;
    }

    public void setBannerId(int bannerId) {
        this.bannerId = bannerId;
    }

    public String getBannerAddress() {
        return bannerAddress;
    }

    public void setBannerAddress(String bannerAddress) {
        this.bannerAddress = bannerAddress;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }
}
