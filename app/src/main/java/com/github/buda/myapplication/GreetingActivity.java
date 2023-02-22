package com.github.buda.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class GreetingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greeting);
        Intent intent = getIntent();
        String value = intent.getStringExtra("name");
        TextView textView = (TextView)  findViewById(R.id.greetingMessage);
        textView.setText("Hello " + value);
    }
}