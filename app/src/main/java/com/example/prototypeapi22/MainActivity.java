package com.example.prototypeapi22;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button ruleButton = (Button)findViewById(R.id.rule);
        ruleButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, rule_view.class);
        startActivity(intent);
        });
    }
}
