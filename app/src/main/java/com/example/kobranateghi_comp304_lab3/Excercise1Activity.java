package com.example.kobranateghi_comp304_lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class Excercise1Activity extends AppCompatActivity {
    ArrayAdapter<String> arrayAdapter2;
    Spinner spinner;
    private Canvas canvas;
    //we use canvas to draw in a bitmap
    private Bitmap bitmap; //the space
    private ImageView imageView;
    private Paint paint;

    private RadioGroup radioGroup;
    private RadioButton redRadioButton, yellowRadioButton,cyanRadioButton;

    //the variables for starting points and ending points
    private int startX=10;
    private int startY=10;
    private int endX=300;
    private int endY=300;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excercise1);

        paint=new Paint();
        paint.setColor(Color.RED);
        
        paint.setStrokeWidth(30);


        arrayAdapter2=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item,
                getResources().getStringArray(R.array.spinnerArray));

        spinner=findViewById(R.id.spinner);
        spinner.setAdapter(arrayAdapter2);


        bitmap=Bitmap.createBitmap((int)getWindowManager().getDefaultDisplay().getWidth(),(int)getWindowManager().getDefaultDisplay().getHeight(),
                Bitmap.Config.ARGB_8888 );
        canvas=new Canvas(bitmap);
        canvas.drawColor(Color.LTGRAY);
        imageView=(ImageView)findViewById(R.id.imageView);

        imageView.setImageBitmap(bitmap);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int thickness=Integer.valueOf(adapterView.getItemAtPosition(i).toString());
                paint.setStrokeWidth(thickness); //20 is our first num in the dropdown menu
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        radioGroup=findViewById(R.id.radioGroup);
        //selecting the radioButton Red

        //we need to create a method for the spinner





        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {

                    redRadioButton = findViewById(R.id.radioButtonRed);
                    yellowRadioButton = findViewById(R.id.radioButtonYellow);
                    cyanRadioButton = findViewById(R.id.radioButtonCyan);
                if (redRadioButton.isChecked()) {
                    paint.setColor(Color.RED);
                }
                    if (yellowRadioButton.isChecked()) {
                        paint.setColor(Color.YELLOW);
                    }
                    if (cyanRadioButton.isChecked()) {
                        paint.setColor(Color.CYAN);
                    }
            }
        });
    }
    public void doDrawing(){
        canvas.drawLine(startX,startY,endX,endY,paint);
        startX=endX;
        startY=endY;
    }
    public void goRight(View view){
        endX=endX+30;
        doDrawing();
    }
    public void goLeft(View view){
        endX=endX-30;
        doDrawing();
    }
    public void goUp(View view){
        endY=endY-30;
        doDrawing();
    }
    public void goDown(View view){
        endY=endY+30;
        doDrawing();
    }
    public void clearCanvas(View view){
        canvas.drawColor(Color.LTGRAY);
        startX=10;
        startY=10;
        endX=300;
        endY=300;

    }

}
