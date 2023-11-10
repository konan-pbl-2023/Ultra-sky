package com.example.prototypeapi22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class RuleView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rule_view);
        Button backButton = (Button)findViewById(R.id.back);
        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(RuleView.this, MainActivity.class);
            startActivity(intent);
        });
    }
}