package com.dilip_sarvaiya_700.dilip_library;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class Registration extends AppCompatActivity {

    EditText username,email,password,conf_password;
    Button btncreate;
    CheckBox terms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        getSupportActionBar().hide();

        username=findViewById(R.id.username);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        conf_password=findViewById(R.id.conf_password);

        final String pkg=getString(R.string.pkg);
        final String cls=getString(R.string.cls);

        btncreate=findViewById(R.id.btn_create);
        terms=findViewById(R.id.terms);

        btncreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isUserValid;
                boolean isEmailValid;
                boolean isPasswordValid;
                boolean isTermsAccepted;
                if(username.getText().toString().equals(""))
                {
                    username.setError("Please enter the username");
                    isUserValid=false;
                }
                else
                {
                    isUserValid=true;
                }
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
                if(password.getText().toString().equals(""))
                {
                    password.setError("Please enter the password");
                    isPasswordValid=false;
                }
                else if(password.getText().toString().equals(conf_password.getText().toString()))
                {
                    isPasswordValid=true;
                }
                else
                {
                    conf_password.setError("Password and Confirm Password does not match");
                    isPasswordValid=false;
                }
                if(terms.isChecked())
                {
                    isTermsAccepted=true;
                }
                else
                {
                    Toast.makeText(Registration.this, "Please accept the terms & conditions", Toast.LENGTH_SHORT).show();
                    isTermsAccepted=false;
                }

                if(isUserValid && isEmailValid && isPasswordValid && isTermsAccepted) {
                    Intent intent = new Intent(android.content.Intent.ACTION_VIEW);
                    intent.putExtra("username", username.getText().toString());
                    intent.putExtra("email",email.getText().toString());
                    intent.putExtra("password", password.getText().toString());
                    intent.setComponent(new ComponentName(pkg, cls));
                    startActivity(intent);
                }
            }
        });
    }

    public void close_form(View view) {
        Intent intent=new Intent(Registration.this,Login.class);
        startActivity(intent);
        finish();
    }
}