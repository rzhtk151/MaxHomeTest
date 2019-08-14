package com.john.bryce.df.maxhometest.ui.fragment.item;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.john.bryce.df.maxhometest.R;
import com.john.bryce.df.maxhometest.ui.activity.MainActivity;
import com.john.bryce.df.maxhometest.util.jsonmodel.DataListObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class DescriptionItemFragment extends Fragment {

    public static final String TAG = "com.john.bryce.df.maxhometest.ui.fragment.item.DescriptionItemFragment.TAG";
    private static String mCategory;
    private static DataListObject data;
    @BindView(R.id.card_view)
    CardView cardView;
    @BindView(R.id.item_image)
    ImageView imageView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.element_id)
    TextView textView;


    private MainActivity activity;
    private Unbinder unbinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        activity.getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
    }

    public DescriptionItemFragment(MainActivity activity, DataListObject object, String category) {
        this.activity = activity;
        this.mCategory = category;
        this.data = object;
    }

    private void setItemDetails(DataListObject details, String category) {
        Glide.with( activity ).load( details.getImag() ).into( imageView );
        textView.setText( details.getId() + "" );
        toolbar.setTitle( category );

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach( context );
        this.activity = (MainActivity) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View layout = LayoutInflater.from( activity ).inflate( R.layout.fragment_item, container, false );
        unbinder = ButterKnife.bind( this, layout );
        setItemDetails( data, mCategory );
        return layout;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
