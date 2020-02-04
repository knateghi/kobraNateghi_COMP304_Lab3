package com.example.kobranateghi_comp304_lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Excercise2Activity extends AppCompatActivity {

   private ImageView imageView;
   private Button startButton, stopButton;
   private AnimationDrawable animationDrawable=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excercise2);

        imageView=findViewById(R.id.imageView2);
    }

    public void startDisplaying(View view){
         BitmapDrawable frame1= (BitmapDrawable) getResources().getDrawable(R.drawable.ninja1);
         BitmapDrawable frame2=(BitmapDrawable) getResources().getDrawable(R.drawable.ninja2);
         BitmapDrawable frame3=(BitmapDrawable) getResources().getDrawable(R.drawable.ninja3);
         BitmapDrawable frame4=(BitmapDrawable) getResources().getDrawable(R.drawable.ninja4);
         BitmapDrawable frame5=(BitmapDrawable) getResources().getDrawable(R.drawable.ninja5);


        animationDrawable = new AnimationDrawable();
        animationDrawable.addFrame(frame1,220);
        animationDrawable.addFrame(frame2,220);
        animationDrawable.addFrame(frame3,220);
        animationDrawable.addFrame(frame4,220);
        animationDrawable.addFrame(frame5,220);

        imageView.setImageDrawable(animationDrawable);
        animationDrawable.start();

    }
    public void stopDisplaying(View view){
        animationDrawable.stop();
        
    }
}
