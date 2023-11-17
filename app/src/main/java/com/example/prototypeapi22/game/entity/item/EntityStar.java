package com.example.prototypeapi22.game.entity.item;

import com.example.prototypeapi22.game.item.ItemStar;

public class EntityStar extends EntityItem {

    public EntityStar(int posX, int posY, int width, int height) {
        super(new ItemStar(), posX, posY, width, height);
    }
}
