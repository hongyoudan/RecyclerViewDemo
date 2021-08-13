package com.hyd.recyclerviewdemo.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.hyd.recyclerviewdemo.R;
import com.hyd.recyclerviewdemo.bean.ItemBean;

import java.util.List;

/**
 * @author hayden
 * @create 2021/8/13 11:06 下午
 */

// 53.同理，更改类方法
public class GridViewAdapter extends RecyclerViewBaseAdapter{

//    private final List<ItemBean> mData;

    public GridViewAdapter(List<ItemBean> data) {
//        this.mData = data;
        super(data);
    }

    @Override
    protected View getSubView(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.item_list_view, null);
        return view;
    }

//    @Override
//    public InnerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//
//        View view = View.inflate(parent.getContext(), R.layout.item_grid_view, null);
//        return new GridViewAdapter.InnerHolder(view);
//    }

//    @Override
//    public void onBindViewHolder(GridViewAdapter.InnerHolder holder, int position) {
//        holder.setData(mData.get(position));
//    }
//
//    @Override
//    public int getItemCount() {
//        if (mData != null) {
//            return mData.size();
//        }
//        return 0;
//    }

//    public class InnerHolder extends RecyclerView.ViewHolder {
//
//        private ImageView mIcon;
//        private TextView mTitle;
//
//        public InnerHolder(View itemView) {
//            super(itemView);
//            mIcon = itemView.findViewById(R.id.icon);
//            mTitle = itemView.findViewById(R.id.title);
//        }
//
//        public void setData(ItemBean itemBean) {
//            mIcon.setImageResource(itemBean.icon);
//            mTitle.setText(itemBean.title);
//
//        }
//    }
}
