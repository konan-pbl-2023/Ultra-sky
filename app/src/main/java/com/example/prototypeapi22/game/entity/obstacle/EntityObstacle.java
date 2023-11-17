package com.example.prototypeapi22.game.entity.obstacle;

import android.graphics.Bitmap;
import com.example.prototypeapi22.game.entity.Entity;

public abstract class EntityObstacle extends Entity {

    public EntityObstacle(Bitmap texture, int posX, int posY, int width, int height) {
        super(texture, posX, posY, width, height);
    }
}
