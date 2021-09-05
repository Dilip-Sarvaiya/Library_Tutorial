package com.dilip_sarvaiya_700.dilip_library;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Forgot_Password extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot__password);
        getSupportActionBar().hide();

        final EditText email;
        final String pkg=getString(R.string.pkg);
        final String cls=getString(R.string.cls);

        email=findViewById(R.id.email);
        Button btnsend;
        btnsend=findViewById(R.id.btnsend);
        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isEmailValid;
                if(email.getText().toString().equals(""))
                {
                    email.setError("Please enter the email");
                    isEmailValid=false;
                }
                else if(!Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches())
                {
                    email.setError("Please enter proper email");
                    isEmailValid=false;
                }
                else
                {
                    isEmailValid=true;
                }
                if(isEmailValid) {
                    Intent intent = new Intent(android.content.Intent.ACTION_VIEW);
                    intent.putExtra("username_email_send", email.getText().toString());
                    intent.setComponent(new ComponentName(pkg, cls));
                    startActivity(intent);
                }
            }
        });
    }

    public void close_form(View view) {
        Intent intent=new Intent(Forgot_Password.this,Login.class);
        startActivity(intent);
        finish();
    }
}