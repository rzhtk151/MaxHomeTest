package com.john.bryce.df.maxhometest.ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.john.bryce.df.maxhometest.R;
import com.john.bryce.df.maxhometest.ui.fragment.item.DescriptionItemFragment;
import com.john.bryce.df.maxhometest.ui.fragment.item.IItemClickListener;
import com.john.bryce.df.maxhometest.util.ItemTextBuilder;
import com.john.bryce.df.maxhometest.util.jsonmodel.DataListObject;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder> {
    private Context context;
    private List<DataListObject> list;
    private String mCategory;


    public ItemAdapter(Context context, List<DataListObject> list, String category) {
        this.context = context;
        this.list = list;
        this.mCategory = category;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( context ).inflate( R.layout.rv_item, parent, false );
        return new MyViewHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.MyViewHolder holder, int position) {
        holder.onBind( position );
        holder.setOnCLickListener( (IItemClickListener) context );
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return (list != null ? list.size() : 0);

    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.title_and_description)
        TextView itemTitle;
        @BindView(R.id.image)
        ImageView imageView;
        int position;
        IItemClickListener iItemClickListener;


        public MyViewHolder(@NonNull View itemView) {
            super( itemView );
            ButterKnife.bind( this, itemView );
            itemView.setOnClickListener( this );
        }

        public void setOnCLickListener(IItemClickListener listener) {
            this.iItemClickListener = listener;

        }



        public void onBind(int position) {
            this.position = position;
            ItemTextBuilder.creataItemDescription( list.get( position ).getTitle(), list.get( position ).getSTitle(), itemTitle );
            //itemTitle.setText( list.get( position ).getTitle() );
            Glide.with( context ).load( list.get( position ).getImag() ).into( imageView );
        }
       // public static void show(@NonNull FragmentManager fragmentManager, @IdRes int parentLayoutId, DataListObject object, String category) {

        @Override
        public void onClick(View view) {
            //DescriptionItemFragment.show(fragmentManager ,R.id.fragmentContainer, list.get(position ),mCategory  );
            iItemClickListener.onItemClickListener( view, getAdapterPosition(), list.get( position ), mCategory );
        }
    }
}
