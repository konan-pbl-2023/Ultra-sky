package com.example.prototypeapi22.game.audio;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

import com.example.prototypeapi22.R;

public class SoundPlayer {

    private static SoundPool soundPool;
    private static int hitSoundNegative;
    private static int hitSoundPositive;

    public SoundPlayer(Context context) {

        soundPool = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);

        hitSoundNegative = soundPool.load(context, R.raw.negative, 1);
        hitSoundPositive = soundPool.load(context, R.raw.positive, 1);
    }

    public void playHitSound() {
        soundPool.play(hitSoundNegative, 1.0f, 1.0f, 1, 0, 1.0f);
    }

    public void playOverSound() {
        soundPool.play(hitSoundPositive, 1.0f, 1.0f, 1, 0, 1.0f);
    }
}