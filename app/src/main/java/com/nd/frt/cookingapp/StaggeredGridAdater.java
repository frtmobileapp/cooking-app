package com.nd.frt.cookingapp;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class StaggeredGridAdater extends RecyclerView.Adapter<StaggeredGridAdater.LinearViewHolder> {
    private Context mContext;

    private List<Product> list = new ArrayList<>();

    public StaggeredGridAdater(Context mContext, List<Product> products) {
        this.mContext = mContext;
        list.clear();
        list.addAll(products);
    }

    @Override
    public StaggeredGridAdater.LinearViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_grid_item, parent, false));
    }

    @Override
    public void onBindViewHolder(StaggeredGridAdater.LinearViewHolder holder, final int position) {
        Product item = list.get(position);
        ViewGroup.LayoutParams lp = holder.mImageView.getLayoutParams();
        int height = (int) (200 + Math.random() * 300);
        lp.height = height;
        holder.mImageView.setLayoutParams(lp);
        holder.mImageView.setImageResource(item.getPic());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mItemClickListener != null) {
                    mItemClickListener.onItemClick(position);
                }
            }
        });

    }

    private MyItemClickListener mItemClickListener;

    public interface MyItemClickListener {
        void onItemClick(int position);
    }

    public void setItemClickListener(MyItemClickListener myItemClickListener) {
        this.mItemClickListener = myItemClickListener;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class LinearViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImageView;

        public LinearViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.iv);
        }
    }
}
