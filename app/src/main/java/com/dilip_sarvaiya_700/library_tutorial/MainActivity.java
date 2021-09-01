package com.dilip_sarvaiya_700.library_tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.dilip_sarvaiya_700.dilip_library.Toasts;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toasts.simpleToast(this,"This is Dilip Sarvaiya's Library");
    }
}