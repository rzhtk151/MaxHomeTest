package com.john.bryce.df.maxhometest.util;

import com.john.bryce.df.maxhometest.util.jsonmodel.Data;
import com.john.bryce.df.maxhometest.util.jsonmodel.DataListObject;

import java.util.ArrayList;

public class GetArrayById {

    public static ArrayList<DataListObject> getAllById(Data data, int catId) {
        ArrayList<DataListObject> array = new ArrayList<>();
        for (int i = 0; i < data.getDataObject().getDataListObject().size() && data.getDataObject().getDataListObject().get( i ).getCatId() <= catId + 1; i++) {
            DataListObject d = data.getDataObject().getDataListObject().get( i );
            if (d.getCatId() == catId + 1)
                array.add( d );
        }
        return array;

    }
}
