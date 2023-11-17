package com.example.prototypeapi22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;

public class RuleActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rule);

        SystemBarController.hide(getWindow());

        Button buttonBack = findViewById(R.id.button_back);
        buttonBack.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

        mediaPlayer = MediaPlayer.create(this, R.raw.game_start);
        mediaPlayer.start();

    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.stop();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        if (hasFocus) {
            SystemBarController.hide(getWindow());
        }
    }
}