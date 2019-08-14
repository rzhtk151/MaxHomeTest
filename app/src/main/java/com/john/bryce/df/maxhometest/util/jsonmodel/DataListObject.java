package com.john.bryce.df.maxhometest.util.jsonmodel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataListObject {

    @SerializedName("CatId")
    private Integer catId;
    @SerializedName("Title")
    private String title;
    @SerializedName("STitle")
    private String sTitle;
    @SerializedName("Imag")
    private String imag;
    @SerializedName("Id")
    private Integer id;
    @SerializedName("DataListAddr")
    private List<DataListAddr> dataListAddr = null;
    @SerializedName("NOV")
    private String nOV;
    @SerializedName("Imge")
    private String imge;
    @SerializedName("ClET")
    private Boolean clET;

    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSTitle() {
        return sTitle;
    }

    public void setSTitle(String sTitle) {
        this.sTitle = sTitle;
    }

    public String getImag() {
        return imag;
    }

    public void setImag(String imag) {
        this.imag = imag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<DataListAddr> getDataListAddr() {
        return dataListAddr;
    }

    public void setDataListAddr(List<DataListAddr> dataListAddr) {
        this.dataListAddr = dataListAddr;
    }

    public String getNOV() {
        return nOV;
    }

    public void setNOV(String nOV) {
        this.nOV = nOV;
    }

    public String getImge() {
        return imge;
    }

    public void setImge(String imge) {
        this.imge = imge;
    }

    public Boolean getClET() {
        return clET;
    }

    public void setClET(Boolean clET) {
        this.clET = clET;
    }

}
