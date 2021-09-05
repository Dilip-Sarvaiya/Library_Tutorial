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

        TextView create,forgot_password;
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        create=findViewById(R.id.create);
        forgot_password=findViewById(R.id.forgot_password);
        Button login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Login.this, username.getText().toString(), Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(android.content.Intent.ACTION_VIEW);
                intent.putExtra("username",username.getText().toString());
                intent.setComponent(new ComponentName("com.dilip_sarvaiya_700.library_tutorial","com.dilip_sarvaiya_700.library_tutorial.MainActivity"));
                startActivity(intent);
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