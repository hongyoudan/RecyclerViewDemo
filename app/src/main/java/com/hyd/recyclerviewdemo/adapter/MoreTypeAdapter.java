package com.hyd.recyclerviewdemo.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hyd.recyclerviewdemo.R;
import com.hyd.recyclerviewdemo.bean.MoreTypeBean;

import java.util.List;

/**
 * @author hayden
 * @create 2021/8/14 11:13 上午
 */
public class MoreTypeAdapter extends RecyclerView.Adapter {

    // 92.因为item有三种类型，因此定义三种常量
    public static final int TYPE_FULL_IMAGE = 0;
    public static final int TYPE_RIGHT_IMAGE = 1;
    public static final int TYPE_THREE_IMAGE = 2;

    private final List<MoreTypeBean> mData;

    // 91.通过构造方法将数据传进来
    public MoreTypeAdapter(List<MoreTypeBean> data) {
        this.mData = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // 96.创建三个不同类型的item，并设置到ViewHolder
        View view;

        // 94.创建ViewHolder
        if (viewType == TYPE_FULL_IMAGE) {
            view = View.inflate(parent.getContext(), R.layout.item_type_full_image, null);
            return new fullImageHolder(view);

        } else if (viewType == TYPE_RIGHT_IMAGE) {
            view = View.inflate(parent.getContext(), R.layout.item_type_right_image, null);
            return new rightImageHolder(view);

        }
        view = View.inflate(parent.getContext(), R.layout.item_type_three_image, null);
        return new threeImageHolder(view);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        // 97.设置数据

    }

    @Override
    public int getItemCount() {

        // 91.判空
        if (mData != null) {
            return mData.size();
        }
        return 0;
    }

    // 93.复写getItemViewType方法，该方法根据条件返回条目类型
    @Override
    public int getItemViewType(int position) {

        MoreTypeBean moreTypeBean = mData.get(position);
        if (moreTypeBean.type == 0) {
            return TYPE_FULL_IMAGE;

        } else if (moreTypeBean.type == 1) {
            return TYPE_RIGHT_IMAGE;

        }
        return TYPE_THREE_IMAGE;

    }

    // 95.依次创建三个ViewHolder
    private class fullImageHolder extends RecyclerView.ViewHolder {

        public fullImageHolder(View itemView) {
            super(itemView);
        }
    }

    private class rightImageHolder extends RecyclerView.ViewHolder {

        public rightImageHolder(View itemView) {
            super(itemView);
        }
    }

    private class threeImageHolder extends RecyclerView.ViewHolder {

        public threeImageHolder(View itemView) {
            super(itemView);
        }
    }


}
