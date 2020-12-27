package com.example.todo_list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class splash_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();

        final Intent i = new Intent(splash_screen.this, MainActivity.class);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                startActivity(i);
                finish();
            }
        }, 2000);
    }
}