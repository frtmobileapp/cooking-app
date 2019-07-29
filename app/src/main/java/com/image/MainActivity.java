
package com.image;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.image.recycle.FooterViewHolder;
import com.image.recycle.HeaderViewHolder;
import com.image.recycle.ItemViewHolder;
import com.image.recycle.MyRecycleAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    private MyRecycleAdapter<Bean> recycleAdapter;
    private List<Bean> recycleList = new ArrayList<Bean>();

    private Activity activity = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.getSupportActionBar().hide();

        this.activity = this;

        recycleList.add(new Bean("Curabitur lobor", "6", R.drawable.a2));
        recycleList.add(new Bean("Mauris non temp", "20", R.drawable.a2));
        recycleList.add(new Bean("Mauris non temp333", "32", R.drawable.a2));

        initRecycleView();
    }

    public void initRecycleView() {
        //1.获取控件
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        //2.设置布局方式
        LinearLayoutManager linear = new LinearLayoutManager(activity);
        linear.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linear);  //线性布局
        //mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));  //网格布局
        mRecyclerView.setHasFixedSize(true);

        //3.设置适配器
        mRecyclerView.setAdapter(recycleAdapter = new MyRecycleAdapter<Bean>(activity,
                -1, null,
                -1, null,
                R.layout.item_main, recycleList) {

            @Override
            public void convertHeader(HeaderViewHolder helper, Object obj) {
            }

            @Override
            public void convertFooter(FooterViewHolder helper, Object obj) {
            }

            @Override
            public void convertItem(ItemViewHolder helper, Bean item) {
                helper.setText(R.id.id_name, item.getName());
                helper.setText(R.id.id_time, item.getTime() + " minutes");
                helper.setImageResource(R.id.id_image, item.getId());
            }
        });

        recycleAdapter.setOnClickListener(new MyRecycleAdapter.OnClickListener() {//查看当前帖子的详情
            @Override
            public void onClick(View view, int position) {
            }

        });

        recycleAdapter.setOnLongClickListener(new MyRecycleAdapter.OnLongClickListener() {
            @Override
            public void onLongClick(View view, int position) {
            }
        });

    }

}
