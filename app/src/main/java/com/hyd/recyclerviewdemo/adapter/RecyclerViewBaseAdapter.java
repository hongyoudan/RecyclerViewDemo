package com.hyd.recyclerviewdemo.adapter;

import android.icu.text.Transliterator;
import android.net.sip.SipSession;
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
    private OnItemClickListener mOnItemClickListener;

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
        holder.setData(mData.get(position), position);
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

    // 71.设置监听（接口/回调）
    // 步骤：
    // 1 创建接口
    // 2 定义接口内部的方法
    // 3 提供设置接口的方法
    // 4 接口方法的调用
    // 75.将参数OnItemClickListener listener传递进来
    public void setOnItemClickListener(OnItemClickListener listener) {

        // 74.通过构造方法设置数据
        this.mOnItemClickListener = listener;

    }

    // 72.创建接口
    public interface OnItemClickListener {

        // 73.定义接口内部的方法
        void onItemClick(int position);
    }

    public class InnerHolder extends RecyclerView.ViewHolder {
        private ImageView mIcon;
        private TextView mTitle;
        private int mPosition;

        public InnerHolder(View itemView) {
            super(itemView);

            mIcon = itemView.findViewById(R.id.icon);
            mTitle = itemView.findViewById(R.id.title);

            // 76.调用条目点击方法
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    // 77.判空
                    if (mOnItemClickListener != null) {
                        mOnItemClickListener.onItemClick(mPosition);
                    }
                }
            });

        }


        public void setData(ItemBean itemBean, int position) {

            // 78.将position保存起来
            this.mPosition = position;

            mIcon.setImageResource(itemBean.icon);
            mTitle.setText(itemBean.title);
        }
    }
}
