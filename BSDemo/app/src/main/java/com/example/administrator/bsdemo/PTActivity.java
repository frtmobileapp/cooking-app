package com.example.administrator.bsdemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class PTActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pt);
        Intent intent=getIntent();
        int id=intent.getIntExtra("imgId",R.mipmap.tu);
        ((ImageView)findViewById(R.id.pt)).setImageResource(id);
    }

    @Override
    protected void onStart() {
        super.onStart();
        NavigationUtil.NavigationBarStatusBar(this,true);
    }
}
