package com.example.asus.demo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SystemNewsActivity extends Activity {
    private ImageView systemback;
//    private MyAdapter adapter;
    private List<Map<String, Object>> mData;
    private ListView newslistView=null;
    private String news[]={"西湖夜跑，你值得拥有","ACM来袭，你准备好了吗","浙大考研大军","国足都赢了，你有什么理由不爱足球"};
//    private ListView listView = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.system_news);
        SysApplication.getInstance().addActivity(this);
        //返回到消息页面
        systemback=(ImageView)findViewById(R.id.systembackward);
        systemback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent messageback = new Intent(SystemNewsActivity.this, NewsActivity.class);
                startActivity(messageback);
            }
        });
//        //显示留言的每一条
//        newslistView = (ListView) findViewById(R.id.systemnews);
//        final List<System_news> atrList = new ArrayList<>();
//        final RequestQueue mQueue = Volley.newRequestQueue(getApplicationContext());
//        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest("http://112.74.57.145:8080/travel/ViewList", null,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//
//                        try {
//                            JSONArray resultJsonArray = response.getJSONArray("value");
//                            for (int i = 0; i < resultJsonArray.length(); i++) {
//                                JSONObject resultJsonObject = resultJsonArray.getJSONObject(i);
//                                System_news attraction1 = new System_news();
////                                attraction1.setViewPic(resultJsonObject.getString("viewPic").toString());
////                                attraction1.setViewLine(resultJsonObject.getString("viewLine").toString());
////                                attraction1.setViewName(resultJsonObject.getString("viewName").toString());
////                                attraction1.setViewInfo(resultJsonObject.getString("viewInfo").toString());
//                                attraction1.setNews(resultJsonObject.getString("viewInfo").toString());
////                                student.setAge(Integer.parseInt(resultJsonObject.getString("lineLevel").toString()));
//                                atrList.add(attraction1);
//                            }
//                            adapter = new MyAdapter(atrList, SystemNewsActivity.this);
//                            newslistView.setAdapter(adapter);
////                            adapter.notifyDataSetChanged();
//
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError volleyError) {
//                Toast.makeText(getApplicationContext(), "获取信息失败", Toast.LENGTH_LONG).show();
//            }
//        });
//        mQueue.add(jsonObjectRequest);
        //显示广告信息

//        newslistView= (ListView) findViewById(R.id.systemnews);
//        List<System_news> stuList=new ArrayList<>();
//        for(int i=0;i<10;i++){
//            System_news stu=new System_news();
////            stu.setAge(10+i);
////            stu.setName("name"+i);
//            stu.setNews("如何进行ACM报名？");
////            stu.setNewsPic(R.drawable.kaoyan);
//            stu.setNewsId(i);
//            stuList.add(stu);
//        }
//        adapter=new MyAdapter(stuList,SystemNewsActivity.this);
//        newslistView.setAdapter(adapter);
        mData = getData();
        ListView newslistView = (ListView)findViewById(R.id.systemnews);
        MyAdapterr adapter = new MyAdapterr(this);
        newslistView.setAdapter(adapter);


    }
    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        for(int i=0;i<news.length;i++){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("aname", news[i]);
//            map.put("aweather",aweather[i]);
//            map.put("ainfo", ainfo[i]);
//            map.put("aline",aline[i]);
            list.add(map);
        }

        return list;
    }
    public class MyAdapterr extends BaseAdapter {

        private LayoutInflater mInflater;

        public MyAdapterr(Context context) {
            this.mInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {

            return mData.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {

            return 0;
        }
        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {

                holder=new ViewHolder();

                //可以理解为从list_attraction获取view  之后把view返回给ListView

                convertView = mInflater.inflate(R.layout.systemnews_list, null);
                holder.aname = (TextView)convertView.findViewById(R.id.snewslisttext);
//                holder.aweather = (TextView)convertView.findViewById(R.id.aweather);
//                holder.ainfo = (TextView)convertView.findViewById(R.id.ainfo);
//                holder.aline = (TextView)convertView.findViewById(R.id.aline);
                convertView.setTag(holder);
            }else {
                holder = (ViewHolder)convertView.getTag();
            }

            holder.aname.setText((String)mData.get(position).get("aname"));
//            holder.aweather.setText((String)mData.get(position).get("aweather"));
//            holder.ainfo.setText((String)mData.get(position).get("ainfo"));
//            holder.aline.setText((String)mData.get(position).get("aline"));
////            holder.viewBtn.setTag(position);
////            //给Button添加单击事件  添加Button之后ListView将失去焦点  需要的直接把Button的焦点去掉
////            holder.viewBtn.setOnClickListener(new View.OnClickListener() {
////
////                @Override
////                public void onClick(View v) {
////                    showInfo(position);
////                }
////            });
//
//            //holder.viewBtn.setOnClickListener(MyListener(position));
//
            return convertView;
        }
    }
    //提取出来方便点
    public final class ViewHolder {
        public TextView aname;
//        public TextView aweather;
//        public TextView ainfo;
//        public TextView aline;
    }
    public void showInfo(int position){

        ImageView img=new ImageView(SystemNewsActivity.this);
        img.setImageResource(R.drawable.kaoyan);
        new AlertDialog.Builder(this).setView(img)
                .setTitle(position)
//                .setMessage("景区名称："+aname[position]+"   价格:"+ainfo[position])
                .show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_system_news, menu);
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
