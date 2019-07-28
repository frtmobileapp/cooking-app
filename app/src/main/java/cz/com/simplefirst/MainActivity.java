
package cz.com.simplefirst;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import cz.com.simplefirst.recycle.FooterViewHolder;
import cz.com.simplefirst.recycle.HeaderViewHolder;
import cz.com.simplefirst.recycle.ItemViewHolder;
import cz.com.simplefirst.recycle.MyRecycleAdapter;

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

        recycleList.add(new Bean("111",
                R.drawable.a1,
                R.drawable.a2,
                R.drawable.a3,
                R.drawable.a4,
                R.drawable.a5,
                R.drawable.a6,
                R.drawable.a7,
                R.drawable.a8,
                R.drawable.a9
        ));

        recycleList.add(new Bean("222",
                R.drawable.a1,
                R.drawable.a2,
                R.drawable.a3,
                R.drawable.a4,
                R.drawable.a5,
                R.drawable.a6,
                R.drawable.a7,
                R.drawable.a8,
                R.drawable.a9
        ));

        recycleList.add(new Bean("333",
                R.drawable.a1,
                R.drawable.a2,
                R.drawable.a3,
                R.drawable.a4,
                R.drawable.a5,
                R.drawable.a6,
                R.drawable.a7,
                R.drawable.a8,
                R.drawable.a9
        ));

        recycleList.add(new Bean("444",
                R.drawable.a1,
                R.drawable.a2,
                R.drawable.a3,
                R.drawable.a4,
                R.drawable.a5,
                R.drawable.a6,
                R.drawable.a7,
                R.drawable.a8,
                R.drawable.a9
        ));

        recycleList.add(new Bean("555",
                R.drawable.a1,
                R.drawable.a2,
                R.drawable.a3,
                R.drawable.a4,
                R.drawable.a5,
                R.drawable.a6,
                R.drawable.a7,
                R.drawable.a8,
                R.drawable.a9
        ));

        initRecycleView();
    }

    public void initRecycleView() {
        //1.获取控件
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        //2.设置布局方式
        LinearLayoutManager linear = new LinearLayoutManager(activity);
        linear.setOrientation(LinearLayoutManager.HORIZONTAL);
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
                helper.setText(R.id.id_text, item.getName());

                helper.setImageResource(R.id.id_image11, item.getId11());
                helper.setImageResource(R.id.id_image12, item.getId12());
                helper.setImageResource(R.id.id_image13, item.getId13());

                helper.setImageResource(R.id.id_image21, item.getId21());
                helper.setImageResource(R.id.id_image22, item.getId22());
                helper.setImageResource(R.id.id_image23, item.getId23());

                helper.setImageResource(R.id.id_image31, item.getId31());
                helper.setImageResource(R.id.id_image32, item.getId32());
                helper.setImageResource(R.id.id_image33, item.getId33());
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
