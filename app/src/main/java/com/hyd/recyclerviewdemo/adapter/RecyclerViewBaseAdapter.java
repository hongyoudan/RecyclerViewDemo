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
 * @create 2021/8/13 11:51 下午
 */

// 41.抽取公共方法并创建RecyclerViewBaseAdapter，创建并导入方法
// 46.将RecyclerViewBaseAdapter类改为抽象类
public abstract class RecyclerViewBaseAdapter extends RecyclerView.Adapter<RecyclerViewBaseAdapter.InnerHolder> {

    // 42.通过构造方法将数据传进来
    private final List<ItemBean> mData;

    public RecyclerViewBaseAdapter(List<ItemBean> data) {
        this.mData = data;
    }

    @Override
    public InnerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 45.创建返回的view
        // 52.将参数传进去
        View view = getSubView(parent, viewType);
        return new InnerHolder(view);
    }

    // 47.创建getSubView抽象方法
    protected abstract View getSubView(ViewGroup parent, int viewType);

    @Override
    public void onBindViewHolder(InnerHolder holder, int position) {

        // 44.设置数据，并创建方法setData
        holder.setData(mData.get(position));
    }

    // 43.复写返回条目个数getItemCount方法
    @Override
    public int getItemCount() {
        //判空
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

            mIcon = itemView.findViewById(R.id.icon);
            mTitle = itemView.findViewById(R.id.title);
        }

        public void setData(ItemBean itemBean) {

            mIcon.setImageResource(itemBean.icon);
            mTitle.setText(itemBean.title);
        }
    }
}
