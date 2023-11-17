package com.example.prototypeapi22.game.stage;

import android.graphics.Canvas;
import android.util.Log;
import com.example.prototypeapi22.game.Game;
import com.example.prototypeapi22.game.entity.Entity;
import com.example.prototypeapi22.game.entity.EntityPlayer;
import com.example.prototypeapi22.game.entity.item.EntityApple;

import java.util.ArrayList;

public class Stage {

    private final ArrayList<Entity> entities = new ArrayList<>();
    private final ArrayList<Entity> removeQueue = new ArrayList<>(); // entities that will remove in next frame

    public Stage() {
        entities.clear();
        removeQueue.clear();

        entities.add(new EntityPlayer(500, 500, 360, 360));
        entities.add(new EntityApple(200, 700, 200, 200));
    }

    public void update() {
        for (Entity entity : entities) {
            if (entity instanceof EntityPlayer) {
                // TODO: Implement player logic
                EntityPlayer player = (EntityPlayer) entity;
                player.moveUp();
            }
        }
        Log.d("Stage", "Field Width: " + Game.fieldWidth);
    }

    public void draw(Canvas c) {
        entities.forEach(e -> e.draw(c));
    }
}