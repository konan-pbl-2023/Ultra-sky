package com.example.prototypeapi22.game.entity.item;

import com.example.prototypeapi22.game.effect.effects.EffectSpeedUp;
import com.example.prototypeapi22.game.entity.Entity;
import com.example.prototypeapi22.game.entity.EntityPlayer;
import com.example.prototypeapi22.game.item.ItemApple;

public class EntityApple extends EntityItem {

    public EntityApple(int posX, int posY, int width, int height) {
        super(new ItemApple(), posX, posY, width, height);
    }

    @Override
    public void onCollideTo(Entity entity) {
        if (entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entity;
            player.addEffect(new EffectSpeedUp());
        }
    }
}
