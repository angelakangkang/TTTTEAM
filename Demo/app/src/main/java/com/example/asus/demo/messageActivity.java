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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class messageActivity extends Activity {
    private ImageView messageback;
    private List<Map<String, Object>> mData;
    private ListView listView=null;
    private String news[]={"西湖去不去","ACM你准备好了吗","浙大考研走着啊","国足都赢了，还不请我吃饭？","校赛电商要不要去，我打算约一波儿"};
    //    private ListView listView = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        SysApplication.getInstance().addActivity(this);

        //返回到消息页面
        messageback=(ImageView)findViewById(R.id.messagebackward);
        messageback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent messageback=new Intent(messageActivity.this,NewsActivity.class);
                startActivity(messageback);
            }
        });

        //message的调用
        mData = getData();
        ListView newslistView = (ListView)findViewById(R.id.messages);
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

                convertView = mInflater.inflate(R.layout.message_list, null);
                holder.aname = (TextView)convertView.findViewById(R.id.chattingnews);
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

        ImageView img=new ImageView(messageActivity.this);
        img.setImageResource(R.drawable.kaoyan);
        new AlertDialog.Builder(this).setView(img)
                .setTitle(position)
//                .setMessage("景区名称："+aname[position]+"   价格:"+ainfo[position])
                .show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_message, menu);
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
