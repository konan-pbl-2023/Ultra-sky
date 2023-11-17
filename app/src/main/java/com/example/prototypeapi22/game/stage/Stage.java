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
import com.example.prototypeapi22.game.entity.item.EntityStar;
import com.example.prototypeapi22.game.entity.obstacle.EntityBird;
import com.example.prototypeapi22.game.entity.obstacle.EntityOctopus;
import com.example.prototypeapi22.game.entity.obstacle.EntitySquid;
import com.example.prototypeapi22.game.entity.obstacle.EntitySun;

import java.util.ArrayList;

public class Stage {

    private final EntityPlayer player;
    private final ArrayList<Entity> entities = new ArrayList<>();
    private final ArrayList<Entity> removeQueue = new ArrayList<>(); // entities that will remove in next frame

    // TODO: Fix this owatteru method
    private static final int GOAL_POSY = -50000;
    private int offsetY = 0;

    public Stage() {
        entities.clear();
        removeQueue.clear();

        player = new EntityPlayer(360, 1920 - 180, 360, 360);

        entities.add(new EntityApple(500, -6000, 200, 200));
        entities.add(new EntityStar(900, -10000, 200, 200));
        entities.add(new EntityBird(600, -15000, 200, 200));
        entities.add(new EntityApple(500, -16000, 200, 200));
        entities.add(new EntitySun(900, -17000, 200, 200));
        entities.add(new EntityBird(600, -18000, 200, 200));
        entities.add(new EntitySquid(500, -19000, 200, 200));
        entities.add(new EntitySun(1000, -25000, 200, 200));
        entities.add(new EntityApple(200, -26000, 200, 200));
        entities.add(new EntityStar(900, -30000, 200, 200));
        entities.add(new EntityBird(600, -31000, 200, 200));
        entities.add(new EntitySquid(300, -22000, 200, 200));
        entities.add(new EntitySun(500, -45000, 200, 200));
        entities.add(new EntityApple(500, -48000, 200, 200));
        entities.add(new EntitySquid(500, -20000, 200, 200));
        entities.add(new EntityOctopus(500, -25000, 200, 200));
        entities.add(new EntityApple(500, -26000, 200, 200));
        entities.add(new EntitySun(900, -30000, 200, 200));
        entities.add(new EntityBird(600, -35000, 200, 200));
        entities.add(new EntitySquid(500, -40000, 200, 200));
        entities.add(new EntityOctopus(500, -45000, 200, 200));
        entities.add(new EntityApple(500, -48000, 200, 200));
    }

    public void update() {
        checkIfCleared(player);

        if (player.isGameOver()) {
            Game.getInstance().getGameSession().setGameState(GameState.GAME_OVER);
        }
        removeQueuedEntities();
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
        offsetY += player.getSpeed();
    }

    private void checkIfCleared(EntityPlayer player) {
        if (player.getPosY() <= GOAL_POSY) {
            Game.getInstance().getGameSession().setGameState(GameState.FINISHED);
        }
    }

    private void removeQueuedEntities() {
        removeQueue.forEach(entities::remove);
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

            // TODO: Add entity effects logic here
            if (e instanceof EffectBadVision) {
                // TODO: Implement
            } else if (e instanceof EffectUncontrollable) {
                // TODO: Implement
            } else if (e instanceof EffectImmortal) {
                // TODO: Implement
            }
        }
    }

    public void draw(Canvas c) {
        drawGoal(c, offsetY);

        entities.forEach(e -> e.draw(c, offsetY));
        player.draw(c, offsetY);
    }

    public void onSwipe(float distX) {
        if (Game.getInstance().getGameSession().getGameState() != GameState.PLAYING) {
            return;
        }
        if (distX > 0) {
            player.moveLeft();
        } else if (distX < 0) {
            player.moveRight();
        }
    }

    private void drawGoal(Canvas c, int offsetY) {
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        Rect dest = new Rect(0, GOAL_POSY - 100 + offsetY, Game.fieldWidth, GOAL_POSY + 100 + offsetY);
        c.drawRect(dest, paint);
    }
}