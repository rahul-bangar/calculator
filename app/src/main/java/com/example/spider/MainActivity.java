package com.example.spider;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView result;
    Button btn;
    EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = findViewById(R.id.editText);
        result= findViewById(R.id.result);
        btn = findViewById(R.id.button);
        btn.setEnabled(false);
        input.addTextChangedListener(textWatcher);
       btn.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View view) {
                                      String inputs = input.getText().toString();
                                       double c= 3.0 * java.lang.Math.pow(10,8);
                                      double vel = Double.parseDouble(inputs);
                                      if(vel<0||vel>=c)
                                          Toast.makeText(MainActivity.this, "Invalid Input", Toast.LENGTH_SHORT).show();
                                      else {
                                          double lorentz;
                                          double t = java.lang.Math.sqrt(1 - vel * vel / ( c * c ));
                                          lorentz = 1 / t;
                                          result.setText(String.valueOf(lorentz));
                                      }

                                   }
                               }); }
    public void openactivity (View v)
     {
         Toast.makeText(this, "Opening Practice Mode", Toast.LENGTH_SHORT).show();
         Intent intent = new Intent(this,PracticeSession.class);
         startActivity(intent);
     }
    private TextWatcher textWatcher= new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String inputv = input.getText().toString();

            if(!inputv.isEmpty())
                btn.setEnabled(true);
            else
                btn.setEnabled(false);
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}



