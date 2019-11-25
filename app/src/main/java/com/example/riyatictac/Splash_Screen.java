package com.example.riyatictac;

import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.os.Handler;
import android.text.Html;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

public class Splash_Screen extends AppCompatActivity {

    private ViewPager mSlideViewPager;
    private LinearLayout mDotsLayout;
    private SlideAdapter slideAdapter;
    private TextView[] mDots;
    private Button mNext;
    private Button mBext;
    private int mCurrentPage;
    private static int SPLASH_TIME_OUT=500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSlideViewPager=findViewById(R.id.SlideViewPager);
        mNext=(Button)findViewById(R.id.next);
        mBext=(Button)findViewById(R.id.back);
        mDotsLayout=findViewById(R.id.DotsLayout);
        slideAdapter=new SlideAdapter(this);
        mSlideViewPager.setAdapter(slideAdapter);
        addDotsIndicator(0);
        mSlideViewPager.addOnPageChangeListener(viewlistener);
        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSlideViewPager.setCurrentItem(mCurrentPage+1);
            }
        });
        mBext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSlideViewPager.setCurrentItem(mCurrentPage-1);
            }
        });
    }
    public void addDotsIndicator(int position)
    {
        mDots=new TextView[3];
        mDotsLayout.removeAllViews();
        for (int i=0;i<mDots.length;i++)
        {
            mDots[i]=new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.transparentWhite));
            mDotsLayout.addView(mDots[i]);

        }
        if (mDots.length>0)
        {
            mDots[position].setTextColor(getResources().getColor(R.color.colorPrimary));
        }
    }
    ViewPager.OnPageChangeListener viewlistener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDotsIndicator(position);
            mCurrentPage=position;
            if (position==0)
            {
                mNext.setEnabled(true);
                mBext.setEnabled(false);
                mBext.setVisibility(View.INVISIBLE);
                mNext.setText("Next");
            }
            if (position==mDots.length-1)
            {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Intent splash = new Intent(Splash_Screen.this, Game.class);
                        startActivity(splash);
                        finish();
                    }
                },SPLASH_TIME_OUT);
            }
            else
            {
                mNext.setEnabled(true);
                mBext.setEnabled(true);
                mBext.setVisibility(View.VISIBLE);
                mNext.setText("Next");
                mBext.setText("Back");
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };


}