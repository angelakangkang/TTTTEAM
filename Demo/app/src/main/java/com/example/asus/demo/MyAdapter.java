package com.example.asus.demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by asus on 2016/12/6.
 */
public class MyAdapter extends BaseAdapter {

    private List<System_news> newsList;
    private LayoutInflater inflater;
//    int[] resImags = {
//            R.drawable.xihu,R.drawable.huangshan
//    };

    public MyAdapter() {
    }

    public MyAdapter(List<System_news> newsList, Context context) {
        this.newsList = newsList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return newsList== null ? 0 : newsList.size();
    }

    @Override
    public System_news getItem(int position) {
        return newsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {



        //加载布局为一个视图
        View view = inflater.inflate(R.layout.systemnews_list, null);
        System_news news = getItem(position);

        //在view视图中查找id为image_photo的控件
//       / ImageView image_photo = (ImageView) view.findViewById(R.id.image_photo);
        EditText tv_name = (EditText) view.findViewById(R.id.snewslisttext);
//        EditText aline=(EditText)view.findViewById(R.id.aline);
//        EditText aweather=(EditText)view.findViewById(R.id.aweather);
//        EditText ainfo=(EditText)view.findViewById(R.id.ainfo);
        ImageView image1=(ImageView)view.findViewById(R.id.snewsimage);
        ImageView image2=(ImageView)view.findViewById(R.id.chatting);


//            image.setImageResource(R.drawable.getViewPic());
//        TextView tv_age = (TextView) view.findViewById(R.id.age);
//        image_photo.setImageResource(student.getPhoto());
        tv_name.setText(news.getNews());
//        aline.setText(student.getViewLine());
//        aweather.setText(student.getViewWeather());
//        ainfo.setText(student.getViewInfo());


//        image.setImageResource();
//        image.setBackGround(R.drawable.abc);
//        image.setImageDrawable(Drawable.createFromPath(student.getViewPic()));
        //imageView.setImageDrawable(Drawable.createFromPath(student.getViewPic()));
//        tv_age.setText(String.valueOf(student.getAge()));
        return view;
    }
}