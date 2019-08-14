package com.john.bryce.df.maxhometest.ui.fragment;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper;
import com.john.bryce.df.maxhometest.R;
import com.john.bryce.df.maxhometest.util.GetArrayById;
import com.john.bryce.df.maxhometest.util.jsonmodel.Data;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ItemGroupAdapter extends RecyclerView.Adapter<ItemGroupAdapter.MyViewHolder> {

    private Context context;
    private Data data;
    private FragmentManager fragmentManager;

    public ItemGroupAdapter(Context context, Data data, FragmentManager fragmentManager) {
        this.context = context;
        this.data = data;
        this.fragmentManager = fragmentManager;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( context ).inflate( R.layout.horizontal_recyclerview_item, parent, false );
        return new MyViewHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bind( position );
        ItemAdapter itemGroupAdapter = new ItemAdapter( context, GetArrayById.getAllById( data, position ), data.getDataObject().getDataListCat().get( position ).getCTitle() );
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager( context, LinearLayoutManager.HORIZONTAL, false );

        GravitySnapHelper gravitySnapHelper = new GravitySnapHelper( Gravity.END );
        gravitySnapHelper.attachToRecyclerView( holder.recyclerView );

        holder.recyclerView.setLayoutManager( layoutManager );
        holder.recyclerView.setAdapter( itemGroupAdapter );


    }

    @Override
    public int getItemCount() {
        return (data != null ? data.getDataObject().getDataListCat().size() : 0);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.cat_title)
        TextView catTitle;
        @BindView(R.id.horizontal_rv_item)
        RecyclerView recyclerView;

        public MyViewHolder(@NonNull View itemView) {
            super( itemView );
            ButterKnife.bind( this, itemView );
        }

        public void bind(int i) {
            if (i < 5)
                catTitle.setText( data.getDataObject().getDataListCat().get( i ).getCTitle() );
        }
    }

}
