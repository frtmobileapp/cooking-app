package com.example.nike.application07290404;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout head;
    private Button btn;
    private Button btom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        head = (LinearLayout) findViewById(R.id.head);
        btn = (Button) findViewById(R.id.btn);
        btom = (Button) findViewById(R.id.btom);

        btn.setOnClickListener(this);
        btom.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                startActivity(new Intent(MainActivity.this,Main2Activity.class));
                break;
            case R.id.btom:

                break;
        }
    }
}
