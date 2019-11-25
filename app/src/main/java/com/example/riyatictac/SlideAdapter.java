package com.example.riyatictac;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class SlideAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;
    public SlideAdapter(Context context)
    {
        this.context=context;
    }
    public int[] slide_images={
            R.drawable.ic1,
            R.drawable.ic2,
            R.drawable.ic3
    };
    public String[] Slide_headings={
      "Tic Tac Toe",
      "Player1",
      "Player2"
    };

    public String[] Slide_description={
            "This is the implementation of simple game into an mobile App . We tried to implement the game as beautifully we can, so hope you enjoy it.",
            "One player will choose 0 as symbol and the rules are very simple",
            "One player will choose X as symbol and the players will change turns one after other."
    };

    @Override
    public int getCount() {
        return Slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==(RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.slide_layout,container,false);
        ImageView slideImageView=(ImageView)view.findViewById(R.id.Pager_ic1);
        TextView slideHeading=(TextView)view.findViewById(R.id.slide_heading1);
        TextView slideDescription=(TextView)view.findViewById(R.id.slide_description);
        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(Slide_headings[position]);
        slideDescription.setText(Slide_description[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
