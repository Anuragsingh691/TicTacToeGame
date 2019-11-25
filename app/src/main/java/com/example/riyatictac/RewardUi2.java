package com.example.riyatictac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class RewardUi2 extends AppCompatActivity {
    private TextView title, desc;
    private ImageView reward_image;
    Animation frombottom,frombottom2;
    private int BACK_TIME_OUT=3000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reward_ui2);
        title=(TextView)findViewById(R.id.reward_title);
        desc=(TextView)findViewById(R.id.reward_desc);
        reward_image=(ImageView)findViewById(R.id.reward_image);
        frombottom= AnimationUtils.loadAnimation(this,R.anim.frombottom);
        frombottom2= AnimationUtils.loadAnimation(this,R.anim.frombottom2);
        title.setAnimation(frombottom2);
        desc.setAnimation(frombottom2);
        reward_image.setAnimation(frombottom);
        final MediaPlayer mp=MediaPlayer.create(this,R.raw.clap);
        mp.start();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(RewardUi2.this,Game.class));
            }
        },BACK_TIME_OUT);

    }
}
