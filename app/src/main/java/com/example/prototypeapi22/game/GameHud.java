package com.example.prototypeapi22.game;

import android.graphics.*;
import com.example.prototypeapi22.game.Game;
import com.example.prototypeapi22.game.utils.TimeUtil;

public class GameHud {

    private static final Paint paint = new Paint();

    public static void renderHud(Canvas c) {
        int canvasWidth = c.getWidth(); // 画面の横幅
        int canvasHeight = c.getHeight(); // 画面の高さ

        /* 時間を表示 */
        String time = TimeUtil.getClockText(Game.getInstance().getGameSession().getElapsedTime());
        resetStyle();
        setTextSize(54);
        drawText(c, time, canvasWidth - getTextWidth(time) - 50, 50, Color.WHITE);
    }

    private static void resetStyle() {
        paint.reset();
    }

    private static void setTextSize(int size) {
        paint.setTextSize(size);
    }

    private static void drawText(Canvas c, String text, float x, float y, int color) {
        paint.setAntiAlias(true);
        paint.setTypeface(Typeface.DEFAULT);
        paint.setColor(color);

        c.drawText(text, x, y, paint);
    }

    private static int getTextWidth(String text) {
        return getTextBounds(text).width();
    }

    private static int getTextHeight(String text) {
        return getTextBounds(text).height();
    }

    private static Rect getTextBounds(String text) {
        Rect bounds = new Rect();
        paint.getTextBounds(text, 0, text.length(), bounds);
        return bounds;
    }
}
