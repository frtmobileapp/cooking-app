package com.example.nike.application07240405;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout v1;
    private LinearLayout v2;
    private LinearLayout v3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        Toolbar toolbar = findViewById(R.id.toorbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.next:
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
                break;
        }

        return false;
    }

    private void initView() {
        v1 = (LinearLayout) findViewById(R.id.v1);
        v2 = (LinearLayout) findViewById(R.id.v2);
        v3 = (LinearLayout) findViewById(R.id.v3);
        v1.setOnClickListener(this);
        v2.setOnClickListener(this);
        v3.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        hidd();
        switch (v.getId())
        {
            case R.id.v1:
                ((ViewGroup) v1).getChildAt(1).setVisibility(View.VISIBLE);

                break;
            case R.id.v2:
                ((ViewGroup) v2).getChildAt(1).setVisibility(View.VISIBLE);

                break;
            case R.id.v3:
                ((ViewGroup) v3).getChildAt(1).setVisibility(View.VISIBLE);

                break;
        }
    }

    public void hidd(){
        ((ViewGroup) v1).getChildAt(1).setVisibility(View.INVISIBLE);
        ((ViewGroup) v2).getChildAt(1).setVisibility(View.INVISIBLE);
        ((ViewGroup) v3).getChildAt(1).setVisibility(View.INVISIBLE);


    }
}
