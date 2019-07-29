package com.hch.finalhomework;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        click(findViewById(R.id.btn1));

        ActionBar ab = getSupportActionBar();

    }

    private void click(View v) {
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutActivity.this.startActivity(new Intent(LayoutActivity.this, MainActivity.class));
            }
        });
    }
}
