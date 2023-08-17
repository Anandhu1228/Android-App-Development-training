package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ActivityHome extends AppCompatActivity {

    String myReceivedEmail,myReceivedusername,mywelcomename;
    TextView txtemail,txtuser,welcomename;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        myReceivedEmail = getIntent().getStringExtra("mykey");
        myReceivedusername = getIntent().getStringExtra("mykey1");

        txtemail = findViewById(R.id.txtemail);
        txtemail.setText(myReceivedEmail);

        txtuser = findViewById(R.id.txtuser);
        txtuser.setText(myReceivedusername);

        welcomename = findViewById(R.id.welcomename);
        welcomename.setText("welcome "+ myReceivedusername);
    }
}
