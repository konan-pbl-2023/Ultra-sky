package com.example.prototypeapi22;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SystemBarController.hide(getWindow());

        Button buttonRule = findViewById(R.id.button_rule);
        buttonRule.setOnClickListener(v -> {
            Intent intent = new Intent(this, RuleActivity.class);
            startActivity(intent);
        });

        Button buttonPlay = findViewById(R.id.button_play);
        buttonPlay.setOnClickListener(v -> {
            Intent intent = new Intent(this, GameActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        if (hasFocus) {
            SystemBarController.hide(getWindow());
        }
    }
}
