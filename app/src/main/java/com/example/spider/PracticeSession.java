package com.example.spider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class PracticeSession extends AppCompatActivity {
    Button button;
    EditText inputv;
    EditText inputl;
    TextView res;
    ConstraintLayout constraintLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_session);
        constraintLayout = findViewById(R.id.rl);
        button = findViewById(R.id.btn);
        inputv = findViewById(R.id.inputv);
        inputl = findViewById(R.id.inputl);
        res = findViewById(R.id.res);
        button.setEnabled(false);
        inputv.addTextChangedListener(textWatcher);
        inputl.addTextChangedListener(textWatcher);
        button.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View view) {
                                          String inputvel = inputv.getText().toString();
                                          String inputlor = inputl.getText().toString();
                                          double c = 3.0 * java.lang.Math.pow(10, 8);
                                          double vel = Double.parseDouble(inputvel);
                                          double calclor = Double.parseDouble(inputlor);
                                          if (vel < 0 || vel >= c)
                                              Toast.makeText(PracticeSession.this, "Invalid speed Input", Toast.LENGTH_SHORT).show();
                                          else {
                                              double lorentz;
                                              double t = java.lang.Math.sqrt(1 - ( vel * vel ) / ( c * c ));
                                              lorentz = 1 / t;
                                              double roundoff = (double) Math.round(lorentz * 10000000) / 10000000;
                                              if (roundoff == calclor) {
                                                  res.setText("Hurray!! Your answer is correct");
                                                  constraintLayout.setBackgroundResource(R.color.green);

                                              }
                                              else{
                                                  Toast.makeText(PracticeSession.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                                                  Vibrator vib=(Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
                                                  vib.vibrate(1000);
                                                 res.setText("The correct answer for Lorentz factor is " + roundoff);
                                                  constraintLayout.setBackgroundResource( R.color.red);

                                              }
                                          }
                                      }
                                  }
        );
    }


   private TextWatcher textWatcher= new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String inputvel = inputv.getText().toString();
            String inputlor = inputl.getText().toString();

            if(!inputlor.isEmpty()&&!inputvel.isEmpty())
                button.setEnabled(true);
            else
                button.setEnabled(false);
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}




/*<RelativeLayout
        android:id="@+id/rl"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                /> */