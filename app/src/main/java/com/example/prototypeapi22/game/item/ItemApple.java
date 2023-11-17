package com.example.prototypeapi22.game.item;

import com.example.prototypeapi22.R;
import com.example.prototypeapi22.game.Game;

public class ItemApple extends Item {

    public ItemApple() {
        super("Apple", Game.getInstance().getResourceLoader().getResource(R.drawable.apple));
    }
}
