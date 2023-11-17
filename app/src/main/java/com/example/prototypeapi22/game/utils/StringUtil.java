package com.example.prototypeapi22.game.utils;

import org.jetbrains.annotations.NotNull;

public class StringUtil {

    public static String padLeft(@NotNull String target, int length, char padChar) {
        int targetLength = target.length();
        if (targetLength >= length) {
            return target;
        }
        StringBuilder sb = new StringBuilder(length);
        for (int i = targetLength; i < length; i++) {
            sb.append(padChar);
        }
        sb.append(target);
        return sb.toString();
    }
}
