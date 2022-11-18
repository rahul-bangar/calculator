package com.example.spider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.TimeZone;

public class Spifactor extends AppCompatActivity {
    TextView spires;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spifactor);
        spires = findViewById(R.id.spires);
        final Handler handler = new Handler();
        int delay = 1000;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Calendar cal=Calendar.getInstance(TimeZone.getTimeZone("GMT+5:30"));
                int hr= cal.get(Calendar.HOUR);
                int min= cal.get(Calendar.MINUTE);
                int sec= cal.get(Calendar.SECOND);
                int fact=1;
                for(int i=hr;i>=1;i--) {
                    fact *= i;
                }
                int cube = (int) Math.pow(min,3);
                double spi=(double)fact/(double)(cube+sec);
                spi= spi*100000/100000;
                spires.setText(String.valueOf(spi));
                handler.postDelayed(this, delay);
            }
        },delay);

    }}

