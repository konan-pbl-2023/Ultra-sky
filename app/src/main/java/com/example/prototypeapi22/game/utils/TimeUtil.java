package com.example.prototypeapi22.game.utils;

public class TimeUtil {

    public static String getClockText(long timeInMillis) {
        long timeInSec = Math.floorDiv(timeInMillis, 1000L);
        String hour = StringUtil.padLeft(String.valueOf(timeInSec / 3600L), 2, '0');
        String minute = StringUtil.padLeft(String.valueOf((timeInSec % 3600L) / 60L), 2, '0');
        String sec = StringUtil.padLeft(String.valueOf((timeInSec % 3600L) % 60L), 2, '0');
        return hour + ":" + minute + ":" + sec;
    }
}
