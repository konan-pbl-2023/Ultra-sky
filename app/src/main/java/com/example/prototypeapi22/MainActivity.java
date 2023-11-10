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

        hideSystemBar();

        Button ruleButton = findViewById(R.id.rule);
        ruleButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RuleView.class);
            startActivity(intent);
        });

        Button playButton = findViewById(R.id.play);
        playButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, GameView.class);
            startActivity(intent);
        });
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        if (hasFocus) {
            hideSystemBar();
        }
    }

    private void hideSystemBar() {
        Window window = getWindow();
        View decorView = window.getDecorView();
        WindowInsetsControllerCompat controller = WindowCompat.getInsetsController(window, decorView);

        controller.setSystemBarsBehavior(WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE);
        decorView.setOnApplyWindowInsetsListener(((view, windowInsets) -> {
            controller.hide(WindowInsetsCompat.Type.systemBars());
            return view.onApplyWindowInsets(windowInsets);
        }));
    }
}
