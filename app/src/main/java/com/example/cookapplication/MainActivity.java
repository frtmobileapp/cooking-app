package com.example.cookapplication;

import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTablayout;
    private ViewPager mVp;
    List<View> views;
    private android.text.Html Html;


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        mTablayout = findViewById(R.id.tabLog);
        mVp = findViewById(R.id.loginPager);
        mVp.setAdapter(new ContentAdapter());
        mTablayout.setupWithViewPager(mVp);
        views = new ArrayList<View>();

        LayoutInflater mLi = LayoutInflater.from(this);
        View view1 = mLi.inflate(R.layout.elements_page, null);
        View view2 = mLi.inflate(R.layout.nutrition_page, null);
        View view3 = mLi.inflate(R.layout.recipe_page, null);
        views.add(view1);
        views.add(view2);
        views.add(view3);

        ContentAdapter adapter = new ContentAdapter();
        mVp.setAdapter(adapter);
        Objects.requireNonNull(mTablayout.getTabAt(0)).setText("ELEMENTS");
        Objects.requireNonNull(mTablayout.getTabAt(1)).setText("NUTRITION");
        Objects.requireNonNull(mTablayout.getTabAt(2)).setText("RECIPE");
        mTablayout.setTabTextColors(Color.LTGRAY, Color.WHITE);

    }

    private class ContentAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return view == o;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            container.addView(views.get(position));
            Log.d("tag", String.valueOf(position));
            return views.get(position);

        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView(views.get(position));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if(id==android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}
