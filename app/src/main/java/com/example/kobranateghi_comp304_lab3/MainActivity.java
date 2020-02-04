package com.example.kobranateghi_comp304_lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    String[] array;
    ListView listView;
    ArrayAdapter<String> arrayAdapter;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView)findViewById(R.id.listView);

        arrayAdapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.arrayOfInfo));

        listView.setAdapter(arrayAdapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if(position==0) {
                    intent = new Intent(getApplicationContext(), Excercise1Activity.class);
                    startActivity(intent);
                }
                if(position==1) {
                    intent = new Intent(getApplicationContext(), Excercise2Activity.class);
                    startActivity(intent);
                }
                if(position==2) {
                    intent = new Intent(getApplicationContext(), Excercise3Activity.class);
                    startActivity(intent);
                }
            }
        });
    }

}
