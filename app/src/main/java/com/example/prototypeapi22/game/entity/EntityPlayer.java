package com.example.prototypeapi22.game.entity;

import com.example.prototypeapi22.R;
import com.example.prototypeapi22.game.Game;

public class EntityPlayer extends Entity {

    private final int baseSpeed = 10;

    private boolean collideTop = false;
    private boolean collideBottom = false;
    private boolean collideLeft = false;
    private boolean collideRight = false;

    public EntityPlayer(int posX, int posY, int width, int height) {
        super(Game.getInstance().getResourceLoader().getResource(R.drawable.plane), posX, posY, width, height);
    }

    public void moveUp() {
        if (collideTop) {
            return;
        }
        setPosY(getPosY() - baseSpeed);
    }

    public void moveDown() {
        if (collideBottom) {
            return;
        }
        setPosY(getPosY() + baseSpeed);
    }

    public void moveLeft() {
        if (collideLeft) {
            return;
        }
        setPosX(getPosX() - baseSpeed);
    }

    public void moveRight() {
        if (collideRight) {
            return;
        }
        setPosX(getPosX() + baseSpeed);
    }

    public boolean isCollideTop() {
        return collideTop;
    }

    public void setCollideTop(boolean collideTop) {
        this.collideTop = collideTop;
    }

    public boolean isCollideBottom() {
        return collideBottom;
    }

    public void setCollideBottom(boolean collideBottom) {
        this.collideBottom = collideBottom;
    }

    public boolean isCollideLeft() {
        return collideLeft;
    }

    public void setCollideLeft(boolean collideLeft) {
        this.collideLeft = collideLeft;
    }

    public boolean isCollideRight() {
        return collideRight;
    }

    public void setCollideRight(boolean collideRight) {
        this.collideRight = collideRight;
    }
}