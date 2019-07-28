package com.example.administrator.bsdemo01;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        click(findViewById(R.id.lk));
        click(findViewById(R.id.cm));
        click(findViewById(R.id.sh));

        ActionBar ab=getSupportActionBar();

    }
    private void click(View v){
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.startActivity(new Intent(MainActivity.this,BSAc.class));
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.menu_search)
            return super.onOptionsItemSelected(item);
        MainActivity.this.startActivity(new Intent(MainActivity.this,BSAc.class));
        return super.onOptionsItemSelected(item);
    }
}
