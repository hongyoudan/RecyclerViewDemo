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

        // 29.设置默认显示的效果
        showList(true, false);

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

//        // 27.设置RecyclerView布局管理器（设置样式）
//        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
//        mList.setLayoutManager(layoutManager);
//
//        // 14.创建适配器 adapter.ListViewAdapter
//        // 25.适配器创建好后回来
//        ListViewAdapter adapter=new ListViewAdapter(mData);
//
//        // 26.设置Adapter到RecyclerView里
//        mList.setAdapter(adapter);


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
                // 27.创建showList方法，当点击子菜单选项时更换样式
                // 33.回到这里，将前面设置好的参数传进去
                // TODO: 2021/8/13 6 09:05
                showList(true, false);
                break;
            case R.id.list_view_vertical_reverse:
                showList(true, true);
                break;
            case R.id.list_view_horizontal_stander:
                showList(false, false);
                break;
            case R.id.list_view_horizontal_reverse:
                showList(false, true);
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

    // 28.将前面准备数据部分的代码抽离并合并到这个方法里
    // 32.因此我们在showList里加入两个参数来控制
    private void showList(boolean isVertical, boolean isReverse) {

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        // 30.通过设置布局管理器的setOrientation方法，来设置水平还是垂直显示
        // 按住command点击setOrientation查看其源码：
        ///**
        //* Sets the orientation of the layout. {@link LinearLayoutManager}
        //* will do its best to keep scroll position.
        //*
        //* @param orientation {@link #HORIZONTAL} or {@link #VERTICAL}
        //*/
        // 它是可以通过HORIZONTAL和VERTICAL参数来控制水平还是垂直显示
        layoutManager.setOrientation(isVertical ? RecyclerView.VERTICAL : RecyclerView.HORIZONTAL);

        // 31.设置正向或者反向显示
        layoutManager.setReverseLayout(isReverse);

        mList.setLayoutManager(layoutManager);
        ListViewAdapter adapter = new ListViewAdapter(mData);
        mList.setAdapter(adapter);
    }
}