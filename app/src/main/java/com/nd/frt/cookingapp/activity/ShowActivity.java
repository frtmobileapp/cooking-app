package com.nd.frt.cookingapp.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.nd.frt.cookingapp.R;
import com.nd.frt.cookingapp.adapter.MyPagerAdapter;

import java.util.ArrayList;

public class ShowActivity extends AppCompatActivity {


    private ViewPager vpager_one;
    private ArrayList<View> aList;
    private MyPagerAdapter mAdapter;
    private ImageView iv_one_dot;
    private ImageView iv_two_dot;
    private ImageView iv_three_dot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        vpager_one = (ViewPager) findViewById(R.id.walk_pager);
        iv_one_dot = findViewById(R.id.iv_one_dot);
        iv_two_dot = findViewById(R.id.iv_two_dot);
        iv_three_dot = findViewById(R.id.iv_three_dot);
        Button btnLog = findViewById(R.id.btnLog);
        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginActivity.start(ShowActivity.this);
            }
        });

        aList = new ArrayList<View>();
        LayoutInflater li = getLayoutInflater();
        aList.add(li.inflate(R.layout.walk_page1, null, false));
        aList.add(li.inflate(R.layout.walk_page2, null, false));
        aList.add(li.inflate(R.layout.walk_page3, null, false));
        mAdapter = new MyPagerAdapter(aList);
        vpager_one.setAdapter(mAdapter);
        iv_one_dot.setSelected(true);

        vpager_one.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.i("MainActivity", String.valueOf(position));
                iv_one_dot.setSelected(position==0);
                iv_two_dot.setSelected(position==1);
                iv_three_dot.setSelected(position==2);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }
}
