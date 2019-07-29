package com.example.administrator.bsdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent=new Intent(this,PTActivity.class);
        findViewById(R.id.pt1).setOnClickListener(this);
        findViewById(R.id.pt2).setOnClickListener(this);
        findViewById(R.id.pt3).setOnClickListener(this);
        findViewById(R.id.pt4).setOnClickListener(this);

        findViewById(R.id.txt0).setOnClickListener(this);
        findViewById(R.id.txt1).setOnClickListener(this);
        findViewById(R.id.txt2).setOnClickListener(this);
        findViewById(R.id.txt3).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Log.e("xxxx","ddd111");
        switch (v.getId()){
            case R.id.pt1:
                intent.putExtra("imgId",R.mipmap.pt);
                break;
            case R.id.pt2:
                intent.putExtra("imgId",R.mipmap.pt1);
                break;
            case R.id.pt3:
                intent.putExtra("imgId",R.mipmap.pt2);
                break;
            case R.id.pt4:
                intent.putExtra("imgId",R.mipmap.pt3);
                break;
           
            default:
                break;

        }
        Log.e("xxxx","ddd");
        startActivity(intent);
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        NavigationUtil.setNavigationBar(this,View.GONE);
//    }
}
