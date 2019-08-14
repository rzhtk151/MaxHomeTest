package com.john.bryce.df.maxhometest.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

import com.john.bryce.df.maxhometest.R;
import com.john.bryce.df.maxhometest.ui.fragment.all.AllFragment;
import com.john.bryce.df.maxhometest.ui.fragment.item.DescriptionItemFragment;
import com.john.bryce.df.maxhometest.ui.fragment.item.IItemClickListener;
import com.john.bryce.df.maxhometest.ui.fragment.pager.MainPagerFragment;
import com.john.bryce.df.maxhometest.util.jsonmodel.DataListObject;

public class MainActivity extends AppCompatActivity  implements IItemClickListener {

    public static final String TAG = "com.john.bryce.df.maxhometest.ui.fragment.item.MainActivity.TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        MainPagerFragment.show(getSupportFragmentManager(), R.id.fragmentContainer);


    }

    @Override
    public void onItemClickListener(View view, int position, DataListObject object, String category) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new DescriptionItemFragment
                (this, object, category)).addToBackStack( null ).commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
