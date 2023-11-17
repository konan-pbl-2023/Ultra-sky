package com.example.prototypeapi22;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Intent backgroundService;
    private MediaPlayer mediaPlayer;

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
