package com.example.prototypeapi22.game.entity.item;

import com.example.prototypeapi22.game.item.ItemApple;

public class EntityApple extends EntityItem {

    public EntityApple(int posX, int posY, int width, int height) {
        super(new ItemApple(), posX, posY, width, height);
    }
}
