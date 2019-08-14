package com.john.bryce.df.maxhometest.util.jsonmodel;

import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("DataObject")
    private DataObject dataObject;

    public DataObject getDataObject() {
        return dataObject;
    }

    public void setDataObject(DataObject dataObject) {
        this.dataObject = dataObject;
    }
}
