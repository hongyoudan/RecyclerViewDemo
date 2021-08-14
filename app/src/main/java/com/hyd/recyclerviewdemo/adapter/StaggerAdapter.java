package com.hyd.recyclerviewdemo.adapter;

import android.view.View;
import android.view.ViewGroup;

import com.hyd.recyclerviewdemo.R;
import com.hyd.recyclerviewdemo.bean.ItemBean;

import java.util.List;

/**
 * @author hayden
 * @create 2021/8/14 8:32 上午
 */
// 60.同理，继承RecyclerViewBaseAdapter，并实现方法
// 61.创建item_stagger_view
public class StaggerAdapter extends RecyclerViewBaseAdapter {
    public StaggerAdapter(List<ItemBean> data) {
        super(data);
    }

    @Override
    protected View getSubView(ViewGroup parent, int viewType) {

        // 62.解析item布局
        View view = View.inflate(parent.getContext(), R.layout.item_stagger_view, null);
        return view;
    }
}
