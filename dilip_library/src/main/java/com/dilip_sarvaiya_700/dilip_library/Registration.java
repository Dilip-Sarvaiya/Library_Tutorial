package com.dilip_sarvaiya_700.dilip_library;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity {

    String pkg=getString(R.string.pkg);
    String cls=getString(R.string.cls);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        getSupportActionBar().hide();

        final EditText username,email,password;
        username=findViewById(R.id.username);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);

        Button btncreate;
        btncreate=findViewById(R.id.btn_create);
        btncreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Registration.this, username.getText().toString(), Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(android.content.Intent.ACTION_VIEW);
                intent.putExtra("username",username.getText().toString());
                intent.setComponent(new ComponentName(pkg,cls));
                startActivity(intent);
            }
        });
    }

    public void close_form(View view) {
        Intent intent=new Intent(Registration.this,Login.class);
        startActivity(intent);
        finish();
    }
}