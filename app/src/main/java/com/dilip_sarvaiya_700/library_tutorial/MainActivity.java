package com.dilip_sarvaiya_700.library_tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txt_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Dashboard");

        txt_name=findViewById(R.id.txt_name);

        Intent intent=getIntent();
        String user= intent.getStringExtra("username");
        String username_email_send= intent.getStringExtra("username_email_send");

        if(username_email_send!=null)
        {
            txt_name.setText("We have e-mailed your password reset link! to "+username_email_send);
        }
        else {
            txt_name.setText("Welcome " + user);
        }
    }
}