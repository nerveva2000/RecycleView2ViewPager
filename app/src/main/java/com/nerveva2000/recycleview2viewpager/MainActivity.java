package com.nerveva2000.recycleview2viewpager;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.nerveva2000.recycleview2viewpager.recyclerView.RecyclerViewAdapter;

import java.util.ArrayList;

public class MainActivity extends Activity implements View.OnClickListener {

    private ArrayList<String> data;
    private RecyclerViewAdapter recyclerViewAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_segment_0 = findViewById(R.id.btn_segment_0);
        Button btn_segment_1 = findViewById(R.id.btn_segment_1);
        Button btn_segment_2 = findViewById(R.id.btn_segment_2);
        btn_segment_0.setOnClickListener(this);
        btn_segment_1.setOnClickListener(this);
        btn_segment_2.setOnClickListener(this);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerViewAdapter = new RecyclerViewAdapter(this);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        //关键点
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        new PagerSnapHelper().attachToRecyclerView(recyclerView);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_segment_0:
                recyclerView.smoothScrollToPosition(0);

                break;
            case R.id.btn_segment_1:
                recyclerView.smoothScrollToPosition(1);
                break;
            case R.id.btn_segment_2:
                recyclerView.smoothScrollToPosition(2);
                break;
            default:
                break;
        }
    }
}
