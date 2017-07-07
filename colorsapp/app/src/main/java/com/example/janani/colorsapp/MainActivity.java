package com.example.janani.colorsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    View view;
    TextView tv;
    int ct=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view = this.getWindow().getDecorView();
        view.setBackgroundResource(R.color.yellow);
        tv =(TextView) findViewById(R.id.counter);
    }
    public void goBlue (View v)
        {view.setBackgroundResource(R.color.blue);
            ct=ct+1;
            if ( ct > 15) {
                ct = 0;
            }
            tv.setText(Integer.toString(ct));
        }
    public void goGreen(View v)
    {view.setBackgroundResource(R.color.green);
        ct=ct+1;
        if ( ct > 15) {
            ct = 0;
        }
        tv.setText(Integer.toString(ct));}
    public void goRed(View v)
        {view.setBackgroundResource(R.color.red);
        ct=ct+1;
            if ( ct > 15) {
                ct = 0;
            }
            tv.setText(Integer.toString(ct));}

   }

