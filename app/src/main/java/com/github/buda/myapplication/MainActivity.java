package com.github.buda.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openGreeting(View view) {
        EditText editText = (EditText) findViewById(R.id.mainName);
        String textContent = editText.getText().toString();
        Intent intent = new Intent(MainActivity.this, GreetingActivity.class);
        intent.putExtra("name", textContent);
        MainActivity.this.startActivity(intent);
    }
}