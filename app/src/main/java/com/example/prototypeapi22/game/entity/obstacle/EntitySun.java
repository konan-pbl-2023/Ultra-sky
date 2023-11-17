package com.example.prototypeapi22.game.entity.obstacle;

import com.example.prototypeapi22.R;
import com.example.prototypeapi22.game.Game;

public class EntitySun extends EntityObstacle {

    public EntitySun(int posX, int posY, int width, int height) {
        super(Game.getInstance().getResourceLoader().getResource(R.drawable.sun), posX, posY, width, height);
    }
}
