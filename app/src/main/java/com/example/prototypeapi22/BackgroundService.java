package com.example.prototypeapi22;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import androidx.annotation.Nullable;

public class BackgroundService extends Service implements MediaPlayer.OnCompletionListener {

    private MediaPlayer mediaPlayer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        mediaPlayer = MediaPlayer.create(this, R.raw.game_start);
        mediaPlayer.setOnCompletionListener(this);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (!mediaPlayer.isPlaying()) {
            mediaPlayer.start();
        }
        return START_STICKY;
    }

    public void onDestroy() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }
        mediaPlayer.release();
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        stopSelf();
    }
}
