package com.john.bryce.df.maxhometest.ui.fragment.item;

import android.view.View;

import com.john.bryce.df.maxhometest.util.jsonmodel.DataListObject;

public interface IItemClickListener {

    void onItemClickListener(View view, int position, DataListObject object, String category);
}
