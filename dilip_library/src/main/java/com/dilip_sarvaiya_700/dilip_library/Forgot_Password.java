package com.dilip_sarvaiya_700.dilip_library;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Forgot_Password extends AppCompatActivity {

    String pkg=getString(R.string.pkg);
    String cls=getString(R.string.cls);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot__password);
        getSupportActionBar().hide();

        final EditText email;
        email=findViewById(R.id.email);
        Button btnsend;
        btnsend=findViewById(R.id.btnsend);
        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Forgot_Password.this, email.getText().toString(), Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(android.content.Intent.ACTION_VIEW);
                intent.putExtra("username_email_send",email.getText().toString());
                intent.setComponent(new ComponentName(pkg,cls));
                startActivity(intent);
            }
        });
    }
}