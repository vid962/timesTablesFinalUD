package com.example.android.timestablesfinalud;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final SeekBar mySeekBar = findViewById(R.id.seekBar);
        mySeekBar.setMax(20);
        mySeekBar.setProgress(10);

        ListView myListView = findViewById(R.id.listView);

       int timeTableNum;




        mySeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Log.i("Seekbar changed", Integer.toString(i));
                int min=1;

                if(i<min) {
                    timeTableNum = min;
                    mySeekBar.setProgress(min);
                }
                else{
                    timeTableNum=i;
                    }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }


        });

        ArrayList<Integer> myArraylist = new ArrayList<Integer>();

        for (int j =1; j<=10; j++){
            myArraylist.add(j*timeTableNum);
        }


        ArrayAdapter<Integer> myArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, myArraylist);

        myListView.setAdapter(myArrayAdapter);




    }
}
