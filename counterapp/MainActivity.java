package com.example.iccarusdroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int myCountValue = 0;
    Button btminus,btplus,reset;
    TextView count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       btminus = findViewById(R.id.btminus);
       btplus = findViewById(R.id.btplus);
       count = findViewById(R.id.counter);
       reset = findViewById(R.id.reset);

       btplus.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               myCountValue = myCountValue+1;
               count.setText(myCountValue + "");   // or  count.setText(string.valueof(myCountValue));
           }
       });
        btminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (myCountValue <= 0)
                {
                    myCountValue = myCountValue;
                }
                else
                {
                    myCountValue = myCountValue-1;
                }
                count.setText(myCountValue + "");
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myCountValue = 0;
                count.setText(myCountValue + "");
            }
        });
    }
}
