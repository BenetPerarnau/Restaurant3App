package com.example.benet.restaurant3app.Model;

import java.io.Serializable;

/**
 * Created by Benet on 21/02/15.
 */
public final class Restaurant implements Serializable {


    private String name, city, district, url;
    private int img;

    public Restaurant(String name, String city, String district, String url, int img) {
        this.name = name;
        this.city = city;
        this.district = district;
        this.url = url;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
