package com.john.bryce.df.maxhometest.util.jsonmodel;

import com.google.gson.annotations.SerializedName;

public class DataListCat {

    @SerializedName("CatId")
    private Integer catId;
    @SerializedName("CTitle")
    private String cTitle;

    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    public String getCTitle() {
        return cTitle;
    }

    public void setCTitle(String cTitle) {
        this.cTitle = cTitle;
    }

}