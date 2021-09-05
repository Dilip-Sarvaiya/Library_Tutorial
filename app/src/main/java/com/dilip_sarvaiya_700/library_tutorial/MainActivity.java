package com.dilip_sarvaiya_700.library_tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txt_name,username_txt,pass_txt,email_txt,email_lbl;
    LinearLayout email_layout,main_layout,pass_layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Dashboard");

        txt_name=findViewById(R.id.txt_name);
        username_txt=findViewById(R.id.username_txt);
        pass_txt=findViewById(R.id.pass_txt);
        email_txt=findViewById(R.id.email_txt);
        email_lbl=findViewById(R.id.email_lbl);

        email_layout=findViewById(R.id.email_layout);
        main_layout=findViewById(R.id.main_layout);
        pass_layout=findViewById(R.id.pass_layout);

        Intent intent=getIntent();
        String user= intent.getStringExtra("username");
        String pass= intent.getStringExtra("password");
        String email= intent.getStringExtra("email");
        String username_email_send= intent.getStringExtra("username_email_send");

        try{
        if(email.equals("blank"))
        {
            email_layout.removeAllViews();
        }
        if(!email.equals("blank"))
        {
            email_txt.setText(email);
        }}
        catch (Exception e)
        {
        }
        if(username_email_send!=null)
        {
            txt_name.setText("We have e-mailed your password reset link! to "+username_email_send);
            email_layout.removeAllViews();
            main_layout.removeAllViews();
            pass_layout.removeAllViews();
        }
        else {
            txt_name.setText("Welcome " + user);
            username_txt.setText(user);
            pass_txt.setText(pass);
        }
    }
}