package com.hyd.recyclerviewdemo.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hyd.recyclerviewdemo.R;
import com.hyd.recyclerviewdemo.bean.ItemBean;

import java.util.List;

/**
 * @author hayden
 * @create 2021/8/13 11:06 下午
 */
public class GridViewAdapter extends RecyclerView.Adapter<GridViewAdapter.InnerHolder> {

    private final List<ItemBean> mData;

    public GridViewAdapter(List<ItemBean> data) {
        this.mData = data;
    }

    @Override
    public InnerHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = View.inflate(parent.getContext(), R.layout.item_grid_view, null);
        return new GridViewAdapter.InnerHolder(view);
    }

    @Override
    public void onBindViewHolder(GridViewAdapter.InnerHolder holder, int position) {
        holder.setData(mData.get(position));
    }

    @Override
    public int getItemCount() {
        if (mData != null) {
            return mData.size();
        }
        return 0;
    }

    public class InnerHolder extends RecyclerView.ViewHolder {

        private ImageView mIcon;
        private TextView mTitle;

        public InnerHolder(View itemView) {
            super(itemView);
            mIcon = itemView.findViewById(R.id.grid_view_icon);
            mTitle = itemView.findViewById(R.id.grid_view_title);
        }

        public void setData(ItemBean itemBean) {
            mIcon.setImageResource(itemBean.icon);
            mTitle.setText(itemBean.title);

        }
    }
}
