package com.dilip_sarvaiya_700.dilip_library;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);
        getSupportActionBar().hide();

        final EditText username,password;

        final String pkg=getString(R.string.pkg);
        final String cls=getString(R.string.cls);

        TextView create,forgot_password;
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        create=findViewById(R.id.create);
        forgot_password=findViewById(R.id.forgot_password);
        Button login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isUserValid;
                boolean isPasswordValid;
                if(username.getText().toString().equals(""))
                {
                    username.setError("Please enter the username");
                    isUserValid=false;
                }
                else
                {
                    isUserValid=true;
                }
                if(password.getText().toString().equals(""))
                {
                    password.setError("Please enter the password");
                    isPasswordValid=false;
                }
                else
                {
                    isPasswordValid=true;
                }
                if(isUserValid && isPasswordValid) {
                    Intent intent = new Intent(android.content.Intent.ACTION_VIEW);
                    intent.putExtra("username", username.getText().toString());
                    intent.putExtra("email","blank");
                    intent.putExtra("password", password.getText().toString());
                    intent.setComponent(new ComponentName(pkg, cls));
                    startActivity(intent);
                }
            }
        });
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Login.this,Registration.class);
                startActivity(intent);
            }
        });

        forgot_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Login.this,Forgot_Password.class);
                startActivity(intent);
            }
        });

    }
}