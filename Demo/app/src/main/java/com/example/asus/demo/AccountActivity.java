package com.example.asus.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by asus on 2017/3/23.
 */
public class AccountActivity extends Activity implements onChangedListeneroff{
    private Button exit1;
    private SlipButton mSlipButton;
    private ImageView fanhui;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userzhanghaoshezhi);
        exit1=(Button)findViewById(R.id.exitt);
//        exit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
        exit1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                SysApplication.getInstance().exit();
            }
        });

        //返回到个人设置界面
        fanhui=(ImageView)findViewById(R.id.usershezhibackward);
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent accountname=new Intent(AccountActivity.this,UserActivity.class);
                startActivity(accountname);
            }
        });


        mSlipButton=(SlipButton)findViewById(R.id.on);
//        mSlipButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
        mSlipButton.SetOnChangedListener(this);
    }
    //这里为开或者关时自己所需要做的动作或实现的内容处理
    public void OnChanged(boolean CheckState) {
        if (CheckState) {
            Toast.makeText(this, "打开了", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "关闭了", Toast.LENGTH_LONG).show();
        }
    }



}
