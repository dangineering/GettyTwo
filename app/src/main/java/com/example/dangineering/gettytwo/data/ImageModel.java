package com.example.dangineering.gettytwo.data;

import java.io.Serializable;

public class ImageModel implements Serializable {
    static final long serialVersionUID =7648189373502970216L;

    private String url;
    private String title;

    public ImageModel(String url, String title) {
        this.url = url;
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
