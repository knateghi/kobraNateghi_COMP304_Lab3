package com.example.kobranateghi_comp304_lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class Excercise3Activity extends AppCompatActivity {

    Button btnStart;
    Button btnStop;
    ImageView iV_moon;
    ImageView iV_earth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excercise3);

        btnStart = findViewById(R.id.btn_start);
        btnStop = findViewById(R.id.btn_stop);
        iV_moon =findViewById(R.id.iV_moon);
        iV_earth=findViewById(R.id.iV_earth);

    }
    public void start(View view)
    {
        Animation moonAnimation = AnimationUtils.loadAnimation(this,R.anim.moon_movment);
        Animation earthAnimation = AnimationUtils.loadAnimation(this,R.anim.spin_around);

       iV_earth.startAnimation(earthAnimation);
       iV_moon.startAnimation(moonAnimation);

    }
    public void stop(View view)
    {
        iV_moon.clearAnimation();
        iV_earth.clearAnimation();
    }


}
