package com.example.riyatictac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView titleImage, DescImage;
    Animation animation;

    private static int SPLASH_TIME_OUT=2500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash__screen);
        titleImage=(ImageView)findViewById(R.id.image_splash);
        DescImage=(ImageView)findViewById(R.id.desc_splash);
        animation= AnimationUtils.loadAnimation(this,R.anim.splash_anim);
        titleImage.setAnimation(animation);
        DescImage.setAnimation(animation);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent splash = new Intent(MainActivity.this, Splash_Screen.class);
                startActivity(splash);
                finish();
            }
        },SPLASH_TIME_OUT);
    }

}
