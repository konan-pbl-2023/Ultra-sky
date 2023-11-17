package com.example.prototypeapi22.game.entity;

import com.example.prototypeapi22.R;
import com.example.prototypeapi22.game.Game;
import com.example.prototypeapi22.game.effect.Effect;
import com.example.prototypeapi22.game.effect.effects.EffectSpeedDown;
import com.example.prototypeapi22.game.effect.effects.EffectSpeedUp;

import java.util.ArrayList;

public class EntityPlayer extends Entity {

    private final ArrayList<Effect> effects = new ArrayList<>();

    private boolean collideTop = false;
    private boolean collideBottom = false;
    private boolean collideLeft = false;
    private boolean collideRight = false;

    private boolean gameOver = false;

    private boolean immortal = false;

    public EntityPlayer(int posX, int posY, int width, int height) {
        super(Game.getInstance().getResourceLoader().getResource(R.drawable.plane), posX, posY, width, height);

        effects.clear();
    }

    @Override
    public void onCollideTo(Entity entity) {
        // Do nothing
    }

    public void addEffect(Effect newEffect) {
        boolean alreadyAffected = false;

        for (Effect effect : effects) {
            if (effect.getDuration() <= 0) {
                continue;
            }
            if (effect.getClass() == newEffect.getClass()) {
                alreadyAffected = true;
                break;
            }
        }
        if (alreadyAffected) {
            return;
        }
        if (immortal && newEffect instanceof EffectSpeedUp) {
            return;
        }
        effects.add(newEffect);
    }

    public int getSpeed() {
        final int baseSpeed = 10;
        int speedMultiplier = 1;

        for (Effect e : effects) {
            if (e.getDuration() <= 0) {
                continue;
            }
            if (e instanceof EffectSpeedUp) {
                speedMultiplier *= 5;
                continue;
            }
            if (e instanceof EffectSpeedDown) {
                speedMultiplier /= 3;
            }
        }
        return baseSpeed * speedMultiplier;
    }

    public void moveUp() {
        if (collideTop) {
            return;
        }
        setPosY(getPosY() - getSpeed());
    }

    public void moveDown() {
        if (collideBottom) {
            return;
        }
        setPosY(getPosY() + getSpeed());
    }

    public void moveLeft() {
        if (collideLeft) {
            return;
        }
        setPosX(getPosX() - getSpeed());
    }

    public void moveRight() {
        if (collideRight) {
            return;
        }
        setPosX(getPosX() + getSpeed());
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public boolean isImmortal() {
        return immortal;
    }

    public void setImmortal(boolean immortal) {
        this.immortal = immortal;
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

    public ArrayList<Effect> getEffects() {
        return effects;
    }
}