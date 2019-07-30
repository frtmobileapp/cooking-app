package com.demo.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ViewPager vp;
    private int[] mImg = new int[]{R.mipmap.ic3, R.mipmap.ic4, R.mipmap.ic5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vp = findViewById(R.id.vp);
        vp.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return mImg.length;
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.item_vp, container, false);
                ImageView iv = view.findViewById(R.id.iv);
                iv.setBackgroundResource(mImg[position]);
                container.addView(view);
                return view;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }
        });
        vp.setOffscreenPageLimit(mImg.length);//设置预加载数量
        vp.setPageMargin(30);//控制两幅图之间的间距
        vp.setCurrentItem(1);
//        vp.setPageTransformer(true,new ZoomOutPageTransformer());

    }

    public void opentwo(View view) {
        startActivity(new Intent(this,Main2Activity.class));
    }

    //设置切换动画
    public class ZoomOutPageTransformer implements ViewPager.PageTransformer {
        //自由控制缩放比例
        private static final float MAX_SCALE = 1f;
        private static final float MIN_SCALE = 0.85f;//0.85f

        @Override
        public void transformPage(View page, float position) {

            if (position <= 1) {

                float scaleFactor = MIN_SCALE + (1 - Math.abs(position)) * (MAX_SCALE - MIN_SCALE);

                page.setScaleX(scaleFactor);

                if (position > 0) {
                    page.setTranslationX(-scaleFactor * 2);
                } else if (position < 0) {
                    page.setTranslationX(scaleFactor * 2);
                }
                page.setScaleY(scaleFactor);
            } else {

                page.setScaleX(MIN_SCALE);
                page.setScaleY(MIN_SCALE);
            }
        }

    }
}
