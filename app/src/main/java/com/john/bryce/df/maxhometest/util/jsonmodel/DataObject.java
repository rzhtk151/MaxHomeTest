package com.john.bryce.df.maxhometest.util.jsonmodel;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class DataObject {
    @SerializedName("DataListObject ")
    private List<DataListObject> dataListObject = null;
    @SerializedName("DataListCat")
    private List<DataListCat> dataListCat = null;

    public List<DataListObject> getDataListObject() {
        return dataListObject;
    }

    public void setDataListObject(ArrayList<DataListObject> dataListObject) {
        this.dataListObject = dataListObject;
    }

    public List<DataListCat> getDataListCat() {
        return dataListCat;
    }

    public void setDataListCat(ArrayList<DataListCat> dataListCat) {
        this.dataListCat = dataListCat;
    }

}
