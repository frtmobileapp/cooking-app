package com.example.viewpagerdemo1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {

    private View view1, view2, view3;
    private ViewPager viewPager;
    private int mSize;
    private List<View> viewList;
    private ImageView iv_one_dot;
    private ImageView iv_two_dot;
    private ImageView iv_three_dot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv_one_dot = findViewById(R.id.image1);
        iv_two_dot = findViewById(R.id.image2);
        iv_three_dot = findViewById(R.id.image3);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        LayoutInflater inflater = getLayoutInflater();
        view1 = inflater.inflate(R.layout.layout1, null);
        view2 = inflater.inflate(R.layout.layout2, null);
        view3 = inflater.inflate(R.layout.layout3, null);

        viewList = new ArrayList<View>();
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);

        Button start_btn = (Button)findViewById(R.id.start_btn);
        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             ActivityHalo.start(MainActivity.this);
            }
        });


        final Button btn_out = findViewById(R.id.close_btn);
        btn_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showdialog(btn_out);
            }
        });


        PagerAdapter pagerAdapter = new PagerAdapter() {
            @Override
            public boolean isViewFromObject(View arg0, Object arg1) {
                return arg0 == arg1;
            }

            @Override
            public int getCount() {
                return viewList.size();
            }

            @Override
            public void destroyItem(ViewGroup container, int position,
                                    Object object) {
                container.removeView(viewList.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(viewList.get(position));
                return viewList.get(position);
            }
        };

        viewPager.setAdapter(pagerAdapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            public void onPageSelected(int position) {
                Log.i("MainActivity", String.valueOf(position));
                if (position == 0) {
                    iv_one_dot.setImageResource(R.drawable.icon_have_dot);
                    iv_two_dot.setImageResource(R.drawable.icon_no_dot);
                    iv_three_dot.setImageResource(R.drawable.icon_no_dot);
                }
                if (position == 1) {
                    iv_one_dot.setImageResource(R.drawable.icon_no_dot);
                    iv_two_dot.setImageResource(R.drawable.icon_have_dot);
                    iv_three_dot.setImageResource(R.drawable.icon_no_dot);
                }
                if (position == 2) {
                    iv_one_dot.setImageResource(R.drawable.icon_no_dot);
                    iv_two_dot.setImageResource(R.drawable.icon_no_dot);
                    iv_three_dot.setImageResource(R.drawable.icon_have_dot);
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }

        });

    }

    public void showdialog(View view) {
        AlertDialog.Builder alertdialogbuilder = new AlertDialog.Builder(this);
        alertdialogbuilder.setMessage("确定要退出程序吗？");
        DialogInterface.OnClickListener click1 = null;
        alertdialogbuilder.setPositiveButton("确定", click1);
        DialogInterface.OnClickListener click2 = null;
        alertdialogbuilder.setNegativeButton("取消", click2);
        AlertDialog alertdialog1 = alertdialogbuilder.create();
        alertdialog1.show();

    }

}