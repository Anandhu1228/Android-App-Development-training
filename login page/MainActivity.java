package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etemail,etpass,etusername;
    Button btlogin;

    String stremail,strpass,strusername;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btlogin = findViewById(R.id.btlogin);
        etemail = findViewById(R.id.etemail);
        etpass = findViewById(R.id.etpass);
        etusername = findViewById(R.id.etusername);

        btlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                stremail = etemail.getText().toString(); // to load the string value into stremail and then to convert it to text file
                strpass = etpass.getText().toString();
                strusername = etusername.getText().toString();

                if(stremail.equals("abcd@gmail.com") && strpass.equals("password")){

                    Intent myMovingIntent = new Intent(MainActivity.this,ActivityHome.class);
                    myMovingIntent.putExtra("mykey",stremail);
                    myMovingIntent.putExtra(("mykey1"),strusername);
                    // stremail is sent from main activity to activity home using mykey
                    // stremail is passed through my key

                    startActivity(myMovingIntent);
                }
                else {
                    Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
