package com.hyd.recyclerviewdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.hyd.recyclerviewdemo.adapter.ListViewAdapter;
import com.hyd.recyclerviewdemo.bean.Datas;
import com.hyd.recyclerviewdemo.bean.ItemBean;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mList;
    private List<ItemBean> mData;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 4.找到控件
        mList = this.findViewById(R.id.recyclerview);
        // 5.准备数据
        initDate();

    }

    // 6.initDate方法用于初始化模拟数据
    private void initDate() {
        // 7.List<DataBean> -> Adapter -> setAdapter -> 显示数据
        // 8.创建 bean.ItemBean

        // 11.创建集合
        mData = new ArrayList<>();

        // 9.创建模拟数据
        for (int i = 0; i < Datas.icons.length; i++) {
            // 10.创建数据对象
            ItemBean data = new ItemBean();
            // 13.创建 bean.Datas
            data.icon = Datas.icons[i];
            data.title = "这是第：" + i + " 个条目";

            // 12.将数据添加到集合里
            mData.add(data);
        }

        // 27.设置RecyclerView布局管理器（设置样式）
        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        mList.setLayoutManager(layoutManager);

        // 14.创建适配器 adapter.ListViewAdapter
        // 25.适配器创建好后回来
        ListViewAdapter adapter=new ListViewAdapter(mData);

        // 26.设置Adapter到RecyclerView里
        mList.setAdapter(adapter);


    }

    // 3.在build.gradle(:app)下加入RecycleView的依赖：implementation 'androidx.recyclerview:recyclerview:1.2.0-alpha05'

    // 1.复写onCreateOptionsMenu方法，设置菜单选项
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // 2.复写onOptionsItemSelected方法，设置子菜单选项的点击事件
    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {
            /**
             * ListView效果
             */
            case R.id.list_view_vertical_stander:
                break;
            case R.id.list_view_vertical_reverse:
                break;
            case R.id.list_view_horizontal_stander:
                break;
            case R.id.list_view_horizontal_reverse:
                break;
            /**
             * GridView效果
             */
            case R.id.grid_view_vertical_stander:
                break;
            case R.id.grid_view_vertical_reverse:
                break;
            case R.id.grid_view_horizontal_stander:
                break;
            case R.id.grid_view_horizontal_reverse:
                break;
            /**
             * 瀑布流效果
             */
            case R.id.stagger_view_vertical_stander:
                break;
            case R.id.stagger_view_vertical_reverse:
                break;
            case R.id.stagger_view_horizontal_stander:
                break;
            case R.id.stagger_view_horizontal_reverse:
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}