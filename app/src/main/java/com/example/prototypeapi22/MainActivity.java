package com.example.prototypeapi22;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Intent backgroundService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        backgroundService = new Intent(this, BackgroundService.class);
        startService(backgroundService);

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

        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.game_start);
        mediaPlayer.start();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        if (hasFocus) {
            SystemBarController.hide(getWindow());
        }
    }
}
