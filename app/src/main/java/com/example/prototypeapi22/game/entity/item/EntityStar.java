package com.example.prototypeapi22.game.entity.item;

import com.example.prototypeapi22.game.effect.effects.EffectImmortal;
import com.example.prototypeapi22.game.entity.Entity;
import com.example.prototypeapi22.game.entity.EntityPlayer;
import com.example.prototypeapi22.game.item.ItemStar;

public class EntityStar extends EntityItem {

    public EntityStar(int posX, int posY, int width, int height) {
        super(new ItemStar(), posX, posY, width, height);
    }

    @Override
    public void onCollideTo(Entity entity) {
        if (entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entity;
            player.addEffect(new EffectImmortal());
        }
    }
}
