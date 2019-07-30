package com.example.mytestapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<GoodsBean> list = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        recyclerView = findViewById(R.id.recycler_view);
        //创建LinearLayoutManager 对象 这里使用 LinearLayoutManager 是线性布局的意思
        LinearLayoutManager layoutmanager = new LinearLayoutManager(this);
        //设置RecyclerView 布局
        recyclerView.setLayoutManager(layoutmanager);
        //设置Adapter
        MyAdapter adapter = new MyAdapter(list);
        recyclerView.setAdapter(adapter);
        findViewById(R.id.search_close_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChidlActivity.startActivity(MainActivity.this);
            }
        });

    }

    private void initData() {
        GoodsBean bean1 = new GoodsBean(R.drawable.icon_kofo, "Fusec veh", "100g", 19.99, 1);
        GoodsBean bean2 = new GoodsBean(R.drawable.icon_lanmei_64, "Mauris non", "130g", 25.00, 1);
        GoodsBean bean3 = new GoodsBean(R.drawable.icon_wandou48, "Fusec vehid", "90g", 30.00, 1);
        GoodsBean bean4 = new GoodsBean(R.drawable.icon_dangao64, "cookie", "100g", 19.00, 1);
        list.add(bean1);
        list.add(bean2);
        list.add(bean3);
        list.add(bean4);
    }

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        private List<GoodsBean> list;

        public MyAdapter(List<GoodsBean> list) {
            this.list = list;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
            ViewHolder holder = new ViewHolder(view);
            return holder;

        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            GoodsBean bean = list.get(position);
            holder.pic.setImageResource(bean.picId);
            holder.name.setText(bean.goodsName);
            holder.unit.setText(bean.goodsUnit);
            holder.money.setText(bean.money + "");
            holder.tv_num.setText(bean.nun + "");
            holder.tv_up.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            ImageView pic;
            TextView name;
            TextView unit;
            TextView money;
            TextView tv_down;
            TextView tv_num;
            TextView tv_up;

            public ViewHolder(View view) {
                super(view);
                pic = view.findViewById(R.id.pic);
                name = view.findViewById(R.id.name);
                unit = view.findViewById(R.id.unit);
                money = view.findViewById(R.id.money);
                tv_down = view.findViewById(R.id.tv_down);
                tv_num = view.findViewById(R.id.tv_num);
                tv_up = view.findViewById(R.id.tv_up);
            }
        }

    }
}
