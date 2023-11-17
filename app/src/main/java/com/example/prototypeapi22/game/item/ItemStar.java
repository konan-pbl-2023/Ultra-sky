package com.example.prototypeapi22.game.item;

import com.example.prototypeapi22.R;
import com.example.prototypeapi22.game.Game;

public class ItemStar extends Item {

    public ItemStar() {
        super("Star", Game.getInstance().getResourceLoader().getResource(R.drawable.star));
    }
}