package com.example.prototypeapi22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Button buttonReplay = findViewById(R.id.replay);
        buttonReplay.setOnClickListener(v -> {
            Intent intent = new Intent(this, GameActivity.class);
            startActivity(intent);
        });

        Button buttonTitle = findViewById(R.id.title);
        buttonTitle.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
    }
}