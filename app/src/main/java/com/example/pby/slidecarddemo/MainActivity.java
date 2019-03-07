package com.example.pby.slidecarddemo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    List<Bean> mDataList;
    RecyclerViewAdapter mAdapter;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mDataList = generateDataList(100);
        mAdapter = new RecyclerViewAdapter(mDataList);
        mRecyclerView.setAdapter(mAdapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new SlideItemTouchCallback(mAdapter));
        mRecyclerView.setLayoutManager(new SlideLayoutManager(3, itemTouchHelper, mRecyclerView));
        itemTouchHelper.attachToRecyclerView(mRecyclerView);
    }

    private List<Bean> generateDataList(int count) {
        List<Bean> dataList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Bean bean = new Bean();
            bean.setString("position = " + i);
            bean.setColor(Color.parseColor(ColorUtils.generateRandomColor()));
            dataList.add(bean);
        }
        return dataList;
    }
}
