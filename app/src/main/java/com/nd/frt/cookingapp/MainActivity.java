package com.nd.frt.cookingapp;

import android.app.Activity;import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;
import android.widget.Toast;


public class MainActivity extends Activity implements OnClickListener,OnMenuItemClickListener{


    private Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        PopupMenu popup = new PopupMenu(this, v);

        MenuInflater inflater = popup.getMenuInflater();

        inflater.inflate(R.menu.home, popup.getMenu());

        popup.setOnMenuItemClickListener(this);

        popup.show();

    }


    @Override
    public boolean onMenuItemClick(MenuItem item) {
        // TODO Auto-generated method stub
        switch (item.getItemId()) {
            case R.id.exit:
                Toast.makeText(this, "退出", Toast.LENGTH_SHORT).show();
                break;
            case R.id.set:
                Toast.makeText(this, "设置", Toast.LENGTH_SHORT).show();
                break;
            case R.id.account:
                Toast.makeText(this, "账号", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return false;
    }

}


