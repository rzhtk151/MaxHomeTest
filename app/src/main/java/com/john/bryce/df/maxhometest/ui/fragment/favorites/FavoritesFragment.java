package com.john.bryce.df.maxhometest.ui.fragment.favorites;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.john.bryce.df.maxhometest.R;
import com.john.bryce.df.maxhometest.ui.activity.MainActivity;
import com.john.bryce.df.maxhometest.ui.fragment.favorites.adapter.favoritesItemGroupAdapter;
import com.john.bryce.df.maxhometest.util.GsonUtils;
import com.john.bryce.df.maxhometest.util.jsonmodel.Data;

import org.json.JSONException;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FavoritesFragment extends Fragment {

    @BindView(R.id.favorites_rv)
    RecyclerView verticalRecyclerView;
    Data data;
    private MainActivity activity;
    private favoritesItemGroupAdapter adapter;

    @Override
    public void onAttach(Context context) {
        super.onAttach( context );
        this.activity = (MainActivity) context;
        updateData();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.fragment_favorites, container, false );
        ButterKnife.bind( this, view );
        inflateLayout();
        return view;
    }



    public void updateData() {
        try {
            data = GsonUtils.getData( activity );
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void inflateLayout() {
        setDefaultRecyclerViewProperties();
    }


    private void setDefaultRecyclerViewProperties() {
        verticalRecyclerView.setLayoutManager( new LinearLayoutManager( activity ) );
        verticalRecyclerView.setHasFixedSize( true );
        verticalRecyclerView.setItemAnimator( null );
        setRecyclerViewAdapter();
    }

    private void setRecyclerViewAdapter() {
        adapter = new favoritesItemGroupAdapter(getContext(), data, getFragmentManager());
        verticalRecyclerView.setAdapter( adapter );
    }
}
