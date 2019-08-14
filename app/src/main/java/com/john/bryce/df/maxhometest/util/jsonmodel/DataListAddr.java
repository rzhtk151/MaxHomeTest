package com.john.bryce.df.maxhometest.util.jsonmodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataListAddr {

    @SerializedName("Addr")
    private String addr;
    @SerializedName("DAd")
    private String dAd;

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getDAd() {
        return dAd;
    }

    public void setDAd(String dAd) {
        this.dAd = dAd;
    }

}
