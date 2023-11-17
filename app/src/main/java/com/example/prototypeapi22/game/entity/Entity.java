package com.example.prototypeapi22.game.entity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Entity {

    private final Bitmap texture;

    private int posX;
    private int posY;

    private final int width;
    private final int height;

    public Entity(Bitmap texture, int posX, int posY, int width, int height) {
        this.texture = texture;
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
    }

    public void draw(Canvas c) {
        int texWidth = texture.getWidth();
        int texHeight = texture.getHeight();
        Rect src = new Rect(0, 0, texWidth, texHeight);

        int top = posY - (height / 2);
        int left = posX - (width / 2);
        int right = posX + (width / 2);
        int bottom = posY + (height / 2);
        Rect dest = new Rect(left, top, right, bottom);

        c.drawBitmap(texture, src, dest, null);
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}