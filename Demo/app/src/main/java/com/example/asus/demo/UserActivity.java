package com.example.asus.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.UserDataHandler;

import java.awt.font.TextAttribute;

/**
 * Created by asus on 2017/3/22.
 */
public class UserActivity extends Activity {
    private ImageView backward;
    private TextView zhanghushezhi;
    private TextView firends;
    private TextView camera;
    private TextView caogoa;
    private TextView zhanghuxinxi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user);
        SysApplication.getInstance().addActivity(this);
        backward=(ImageView)findViewById(R.id.img_backward);
        backward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back=new Intent(UserActivity.this,MainActivity.class);
                startActivity(back);
            }
        });
        zhanghushezhi=(TextView)findViewById(R.id.zhanghushezhi);
        zhanghushezhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent zhanghushezhi=new Intent(UserActivity.this,AccountActivity.class);
                zhanghushezhi.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(zhanghushezhi);
            }
        });


    }
}
