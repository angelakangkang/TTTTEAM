package com.example.asus.demo;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * Created by asus on 2017/3/23.
 */
public class BegainActivity extends Activity {
    private TextView mturnTextView;
    private static final String TAG="BegainActivity";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.begin);
        SysApplication.getInstance().addActivity(this);
        Log.d(TAG, "onCreate(Bundle) called");
        mturnTextView=(TextView)findViewById(R.id.textView);
        mturnTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ComponentName componentname = new ComponentName(BegainActivity.this, LoginActivity.class);
                Intent intent = new Intent();
                intent.setComponent(componentname);
                startActivity(intent);

            }
        });

    }
}
