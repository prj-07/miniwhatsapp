package com.example.minstagram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class welcome extends AppCompatActivity {
    EditText wel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_welcome);

        wel = findViewById(R.id.welcome);
        String name= getIntent().getStringExtra("name");
        wel.setText(name);
    }
}