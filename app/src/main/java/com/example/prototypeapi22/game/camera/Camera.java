package com.example.prototypeapi22.game.camera;

public class Camera {

    private int posX;
    private int posY;

    private final int viewWidth;
    private final int viewHeight;

    public Camera(int posX, int posY, int viewWidth, int viewHeight) {
        this.posX = posX;
        this.posY = posY;
        this.viewWidth = viewWidth;
        this.viewHeight = viewHeight;
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

    public int getViewWidth() {
        return viewWidth;
    }

    public int getViewHeight() {
        return viewHeight;
    }
}
