package com.nd.frt.cookingapp;
import java.util.ArrayList;import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;import android.widget.Toast;
public class MainActivity extends Activity {
	private LinearLayout ll_item;
    private ImageView blue_iv;
    private Button btn;
    int position;
    private int pointWidth;
    private int[] images = {R.layout.activity_main,R.layout.activity_main2,R.layout.activity_main3};

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
		ViewPager viewPager = findViewById(R.id.viewpager);
		List<ImageView> list = new ArrayList<>();
        ll_item = findViewById(R.id.ll_item);
        blue_iv = findViewById(R.id.blue_iv);
        btn = findViewById(R.id.top);
        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Click", Toast.LENGTH_SHORT).show();			}		});
        		for(int i=0;i<images.length;i++){
        		    ImageView imageView = new ImageView(this);
        		    imageView.setImageResource(images[i]);
        		    list.add(imageView);
        		    ImageView points = new ImageView(this);
        		    points.setImageResource(R.drawable.shape);
        		    LinearLayout.LayoutParams lllp = new LinearLayout.LayoutParams(
        		            LinearLayout.LayoutParams.WRAP_CONTENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT);
        		    if(i>0)
        		        lllp.leftMargin = 30;
        		    points.setLayoutParams(lllp);
        		    ll_item.addView(points);
        		    blue_iv.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
        		        @Override
                        public void onGlobalLayout() {
        		            pointWidth = ll_item.getChildAt(1).getLeft()-ll_item.getChildAt(0).getLeft();			}		});
        		    VPAdapter vpAdapter = new VPAdapter();
        		    viewPager.setAdapter((PagerAdapter) vpAdapter);
        		    viewPager.addOnPageChangeListener(new OnPageChangeListener() {
        		        @Override
                        public void onPageSelected(int arg0) {
        		            position = arg0;
        		        }
        		        @Override
                        public void onPageScrolled(int arg0, float arg1, int arg2) {
        		            int width;
        		            width = (int) (arg1*pointWidth+arg0*pointWidth);
        		            RelativeLayout.LayoutParams rllp= (LayoutParams) blue_iv.getLayoutParams();
        		            rllp.leftMargin=width;
        		            blue_iv.setLayoutParams(rllp);
        		         if(position==images.length-1&&arg1==0)
        		             btn.setVisibility(View.VISIBLE);
        		         else
        		             btn.setVisibility(View.INVISIBLE);			}
        		             @Override
                             public void onPageScrollStateChanged(int arg0) {			}		});	}
	}}



