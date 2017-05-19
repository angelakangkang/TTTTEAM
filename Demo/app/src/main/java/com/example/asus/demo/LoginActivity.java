package com.example.asus.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class LoginActivity extends Activity {
    private ImageView mroutTurn;
    private Button mButton;
    private String username;
    private String password;
    private Button mLoginButton;

    private EditText Usernameedit;

    private EditText Passwordedit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        SysApplication.getInstance().addActivity(this);
        mLoginButton = (Button) findViewById(R.id.LOGIN);
        Usernameedit = (EditText) findViewById(R.id.username);
        Passwordedit = (EditText) findViewById(R.id.password);
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestQueue mQueue = Volley.newRequestQueue(getApplicationContext());
                username = Usernameedit.getText().toString();
                password = Passwordedit.getText().toString();
                StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://112.74.57.145:8080/travel/login",
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                try {
                                    JSONObject js = new JSONObject(response);
                                    String state = js.getString("state");

                                    if(state.equals("1")){
                                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                        startActivity(intent);
                                    }
                                    else {
                                        Toast.makeText(getApplicationContext(), "用户名或者密码错误", Toast.LENGTH_SHORT).show();
                                    }

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                Log.d("TAG", response);
                            }
                        },
                        new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {
                                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
                                        Log.e("TAG", error.getMessage(), error);
                                    }
                                }) {
                    public Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> map = new HashMap<String,String>();


                        map.put("Admin", username);
                        map.put("PassWord",password);
                        return map;
                    }
                };
                mQueue.add(stringRequest);
            }
        });



    }


}
