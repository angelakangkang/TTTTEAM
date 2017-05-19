package com.example.asus.demo;

import java.util.ArrayList;
        import java.util.List;

        import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.os.SystemClock;
        import android.support.v4.view.ViewPager;
        import android.support.v4.view.ViewPager.OnPageChangeListener;
        import android.view.View;
        import android.widget.ImageView;
        import android.widget.LinearLayout;
        import android.widget.LinearLayout.LayoutParams;
        import android.widget.RadioButton;
        import android.widget.TextView;

public class MainActivity extends Activity {
    private RadioButton home;
    private RadioButton fabu;
    private RadioButton news;
    private RadioButton team;
    private RadioButton user;
    // �����ؼ�
    private ViewPager mViewPager;
    private List<ImageView> mlist;
    private TextView mTextView;
    private LinearLayout mLinearLayout;

    // ���ͼ�ز�
    private int[] bannerImages = { R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4 };
    // �����
    private String[] bannerTexts = { "��Ϊרҵ ����׿Խ", "��ִ��� ��ҵ����", "���� רҵ ˫Ӯ", "��ϸ ��г ���� ����" };

    // ViewPager�������������
    private BannerAdapter mAdapter;
    private BannerListener bannerListener;

    // ԲȦ��־λ
    private int pointIndex = 0;
    // �̱߳�־
    private boolean isStop = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SysApplication.getInstance().addActivity(this);
        initView();
        initData();
        initAction();


        // �������̣߳�2��һ�θ���Banner
        new Thread(new Runnable() {

            @Override
            public void run() {
                while (!isStop) {
                    SystemClock.sleep(2000);
                    runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1);
                        }
                    });
                }
            }
        }).start();
        //�ص���ҳ�İ�ť
        home=(RadioButton)findViewById(R.id.homeRb);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home = new Intent(MainActivity.this, MainActivity.class);
                startActivity(home);
            }
        });
        //��ת���û�����
        user=(RadioButton)findViewById(R.id.searchRb);
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home1=new Intent(MainActivity.this,UserActivity.class);
                startActivity(home1);
            }
        });
        //��ת��������Ϣ����
        fabu=(RadioButton)findViewById(R.id.trolleryRb);
        fabu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home2=new Intent(MainActivity.this,FabuACtivity.class);
                startActivity(home2);
            }
        });
        //��ת����Ϣ�������
        news=(RadioButton)findViewById(R.id.memberRb);
        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home3=new Intent(MainActivity.this,NewsActivity.class);
                startActivity(home3);
            }
        });
        //��ת��TȦ����
        team=(RadioButton)findViewById(R.id.prosortRb);
        team.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home4=new Intent(MainActivity.this,TeamActivity.class);
                startActivity(home4);
            }
        });

    }

    /**
     * ��ʼ���¼�
     */
    private void initAction() {
        bannerListener = new BannerListener();
        mViewPager.setOnPageChangeListener(bannerListener);
        //ȡ�м�������Ϊ��ʼλ��
        int index = (Integer.MAX_VALUE / 2) - (Integer.MAX_VALUE / 2 % mlist.size());
        //��������������
        mViewPager.setCurrentItem(index);
        mLinearLayout.getChildAt(pointIndex).setEnabled(true);
    }

    /**
     * ��ʼ������
     */
    private void initData() {
        mlist = new ArrayList<ImageView>();
        View view;
        LayoutParams params;
        for (int i = 0; i < bannerImages.length; i++) {
            // ���ù��ͼ
            ImageView imageView = new ImageView(MainActivity.this);
            imageView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
            imageView.setBackgroundResource(bannerImages[i]);
            mlist.add(imageView);
            // ����ԲȦ��
            view = new View(MainActivity.this);
            params = new LayoutParams(5, 5);
            params.leftMargin = 10;
            view.setBackgroundResource(R.drawable.point_background);
            view.setLayoutParams(params);
            view.setEnabled(false);

            mLinearLayout.addView(view);
        }
        mAdapter = new BannerAdapter(mlist);
        mViewPager.setAdapter(mAdapter);
    }

    /**
     * ��ʼ��View����
     */
    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mTextView = (TextView) findViewById(R.id.tv_bannertext);
        mLinearLayout = (LinearLayout) findViewById(R.id.points);
    }

    //ʵ��VierPager�������ӿ�
    class BannerListener implements OnPageChangeListener {

        @Override
        public void onPageScrollStateChanged(int arg0) {
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override
        public void onPageSelected(int position) {
            int newPosition = position % bannerImages.length;
            mTextView.setText(bannerTexts[newPosition]);
            mLinearLayout.getChildAt(newPosition).setEnabled(true);
            mLinearLayout.getChildAt(pointIndex).setEnabled(false);
            // ���±�־λ
            pointIndex = newPosition;

        }

    }

    @Override
    protected void onDestroy() {
        // �رն�ʱ��
        isStop = true;
        super.onDestroy();
    }

}