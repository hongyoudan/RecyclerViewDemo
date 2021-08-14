package com.hyd.recyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.hyd.recyclerviewdemo.adapter.MoreTypeAdapter;
import com.hyd.recyclerviewdemo.bean.Datas;
import com.hyd.recyclerviewdemo.bean.MoreTypeBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MoreTypeActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<MoreTypeBean> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_type);

        // 83.找到控件
        mRecyclerView = findViewById(R.id.recyclerView);

        // 84.准备数据，创建bean.MoreTypeBean
        mData = new ArrayList<>();

        // 87.提取方法初始化
        initDatas();

        // 89.设置布局管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        // 88.创建适配器adapter.MoreTypeAdapter
        // 90.创建完成后回来设置适配器
        MoreTypeAdapter adapter = new MoreTypeAdapter(mData);
        mRecyclerView.setAdapter(adapter);

    }

    private void initDatas() {
        // 85.创建随机数对象
        Random random = new Random();

        for (int i = 0; i < Datas.icons.length; i++) {
            MoreTypeBean data = new MoreTypeBean();

            data.pic = Datas.icons[i];

            // 86.添加随机条目类型
            data.type = random.nextInt(3);

            mData.add(data);

        }
    }
}