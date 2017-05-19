package com.example.asus.demo;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;


public class NewsActivity extends Activity {
    private ImageView chat;
    private ImageView newsback;
    private ImageView message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news);
        SysApplication.getInstance().addActivity(this);
        chat=(ImageView)findViewById(R.id.Systemnews);
        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Systemnews = new Intent(NewsActivity.this, SystemNewsActivity.class);
                startActivity(Systemnews);
            }
        });
        message=(ImageView)findViewById(R.id.messages);
        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent messages=new Intent(NewsActivity.this,messageActivity.class);
                startActivity(messages);
            }
        });

        //返回到主页面
        newsback=(ImageView)findViewById(R.id.newsbackward);
        newsback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newsbackaway=new Intent(NewsActivity.this,MainActivity.class);
                startActivity(newsbackaway);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_news, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
