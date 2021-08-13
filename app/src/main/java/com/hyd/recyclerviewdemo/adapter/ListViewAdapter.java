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
 * @create 2021/8/13 5:10 下午
 */
// 15.继承于RecyclerView.Adapter，范型为ListViewAdapter.InnerHolder，并按 Option+Enter 创建及实现方法
public class ListViewAdapter extends RecyclerView.Adapter<ListViewAdapter.InnerHolder> {

    private final List<ItemBean> mData;

    // 16.通过构造方法将数据传进来
    public ListViewAdapter(List<ItemBean> data) {
        this.mData = data;
    }

    // 18.复写用于创建条目View的onCreateViewHolder方法
    @Override
    public InnerHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // 20.将条目界面传进来，并加入InnerHolder参数里
        View view = View.inflate(parent.getContext(), R.layout.item_list_view, null);

        // 19.因为该方法返回的是InnerHolder，因此我们要new一个InnerHolder，
        // 此时InnerHolder需要传入一个参数View即条目的界面，因此要创建 item_list_view
        return new InnerHolder(view);
    }

    // 21.复写用于绑定Holder设置数据的onBindViewHolder方法
    @Override
    public void onBindViewHolder(ListViewAdapter.InnerHolder holder, int position) {

        // 22.设置数据，并创建方法setData
        holder.setData(mData.get(position));

    }

    // 17.复写返回条目个数getItemCount方法
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

            // 23.找到条目控件
            mIcon = itemView.findViewById(R.id.list_view_icon);
            mTitle = itemView.findViewById(R.id.list_view_title);
        }

        public void setData(ItemBean itemBean) {

            // 24.设置数据
            mIcon.setImageResource(itemBean.icon);
            mTitle.setText(itemBean.title);
        }
    }
}
