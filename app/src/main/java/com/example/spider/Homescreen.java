package com.example.spider;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Homescreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);
    }
    public void lorentzCalc (View v)
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public void SpiCalc (View v)
    {
        Intent intent = new Intent(this,Spifactor.class);
        startActivity(intent);
    }
}