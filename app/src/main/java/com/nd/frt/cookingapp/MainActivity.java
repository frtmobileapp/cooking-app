package com.nd.frt.cookingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private RecyclerView mRecyclerView;
    private StaggeredGridAdater adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mRecyclerView = findViewById(R.id.RecyclerView);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        List<Product> datas = new ArrayList<>();
        datas.add(new Product("dakj", R.mipmap.a, "djkaldjalkjdla", "15min"));
        datas.add(new Product("dakj", R.mipmap.b, "djkaldjalkjdla", "15min"));
        datas.add(new Product("dakj", R.mipmap.c, "djkaldjalkjdla", "15min"));
        datas.add(new Product("dakj", R.mipmap.d, "djkaldjalkjdla", "15min"));
        datas.add(new Product("dakj", R.mipmap.e, "djkaldjalkjdla", "15min"));
        datas.add(new Product("dakj", R.mipmap.f, "djkaldjalkjdla", "15min"));
        mRecyclerView.setAdapter(adapter = new StaggeredGridAdater(MainActivity.this, datas));
        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, EmptyActivity.class));
            }
        });
        adapter.setItemClickListener(new StaggeredGridAdater.MyItemClickListener() {
            @Override
            public void onItemClick(int position) {
                startActivity(new Intent(MainActivity.this, EmptyActivity.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.icon_search:
                startActivity(new Intent(MainActivity.this, EmptyActivity.class));
                break;
            case R.id.action_set:
                startActivity(new Intent(MainActivity.this, EmptyActivity.class));
                break;
            case R.id.action_about:
                startActivity(new Intent(MainActivity.this, EmptyActivity.class));
                break;
            default:
        }
        return true;
    }
}
