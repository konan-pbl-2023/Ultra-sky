package com.example.prototypeapi22.game.entity.item;

import com.example.prototypeapi22.game.entity.Entity;
import com.example.prototypeapi22.game.item.Item;

public abstract class EntityItem extends Entity {

    private final Item item;

    public EntityItem(Item item, int posX, int posY, int width, int height) {
        super(item.getTexture(), posX, posY, width, height);
        this.item = item;
    }

    public Item getItem() {
        return item;
    }
}
