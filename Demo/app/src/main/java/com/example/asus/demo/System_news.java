package com.example.asus.demo;

/**
 * Created by asus on 2017/3/25.
 */
public class System_news {
    private int NewsId;
    private String News;
    private String NewsPic;
    public System_news(String news,String newsPic){
        news=News;
        newsPic=NewsPic;

    }
    public  System_news(){
    }
    public  int getNewsId(){
        return NewsId;
    }
    public void  setNewsId(int newsId){
        NewsId=newsId;
    }
    public  String getNews(){
        return News;
    }
    public void  setNews(String news){
        News=news;
    }
    public  String getNewsPic(){
        return NewsPic;
    }
    public void  setNewsPic(String newsPic){
        NewsPic=newsPic;
    }

}
