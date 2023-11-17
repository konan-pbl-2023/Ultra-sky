package com.example.prototypeapi22.game.stage;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import com.example.prototypeapi22.game.Game;
import com.example.prototypeapi22.game.GameState;
import com.example.prototypeapi22.game.effect.Effect;
import com.example.prototypeapi22.game.effect.effects.EffectBadVision;
import com.example.prototypeapi22.game.effect.effects.EffectImmortal;
import com.example.prototypeapi22.game.effect.effects.EffectUncontrollable;
import com.example.prototypeapi22.game.entity.Entity;
import com.example.prototypeapi22.game.entity.EntityPlayer;
import com.example.prototypeapi22.game.entity.item.EntityApple;

import java.util.ArrayList;

public class Stage {

    private final EntityPlayer player;
    private final ArrayList<Entity> entities = new ArrayList<>();
    private final ArrayList<Entity> removeQueue = new ArrayList<>(); // entities that will remove in next frame

    private static final int GOAL_POSY = -10000;

    public Stage() {
        entities.clear();
        removeQueue.clear();

        player = new EntityPlayer(500, 3000, 360, 360);
        entities.add(new EntityApple(500, 1000, 200, 200));
    }

    public void update() {
        if (player.isGameOver()) {
            Game.getInstance().getGameSession().setGameState(GameState.GAMEOVER);
        }
        updatePlayerCollision(player);
        updatePlayerEffects(player);

        for (Entity entity : entities) {
            if (entity.isCollideTo(player)) {
                entity.onCollideTo(player);

                if (!removeQueue.contains(entity)) {
                    removeQueue.add(entity);
                }
            }
        }
        player.moveUp();
    }

    private void updatePlayerCollision(EntityPlayer player) {
        boolean playerCollideLeft = player.getPosX() - (player.getWidth() / 2) <= 0;
        boolean playerCollideRight = player.getPosX() + (player.getWidth() / 2) >= Game.fieldWidth;
        boolean playerCollideBottom = player.getPosY() + (player.getHeight() / 2) >= Game.fieldHeight;

        player.setCollideLeft(playerCollideLeft);
        player.setCollideRight(playerCollideRight);
        player.setCollideBottom(playerCollideBottom);
    }

    private void updatePlayerEffects(EntityPlayer player) {
        for (Effect e : player.getEffects()) {
            if (e.getDuration() <= 0) {
                continue;
            }
            e.setDuration(e.getDuration() - (1000 / Game.FPS));

            if (e instanceof EffectBadVision) {
                // TODO: Implement
            }
            if (e instanceof EffectUncontrollable) {
                // TODO: Implement
            }
            if (e instanceof EffectImmortal) {
                // TODO: Implement
            }
        }
    }

    public void draw(Canvas c) {
        drawGoal(c);
        entities.forEach(e -> e.draw(c));
        player.draw(c);
    }

    private void drawGoal(Canvas c) {
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(20.0F);
        Rect dest = new Rect(0, GOAL_POSY - 100, Game.fieldWidth, GOAL_POSY + 100);
        c.drawRect(dest, paint);
    }
}