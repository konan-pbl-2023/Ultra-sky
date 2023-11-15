package com.example.prototypeapi22.game.renderer;

import android.graphics.*;

public class GameHud {

    private static final Paint paint = new Paint();

    public static void renderHud(Canvas c) {
        int canvasWidth = c.getWidth(); // 画面の横幅
        int canvasHeight = c.getHeight(); // 画面の高さ

        // 画面上のテキストなどをここに書く
        resetStyle();
        setTextSize(36);
        drawText(c, "Hello World", 50, 50, Color.GREEN);
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
