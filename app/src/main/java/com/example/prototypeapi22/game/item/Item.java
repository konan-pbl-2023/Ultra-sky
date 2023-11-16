package com.example.prototypeapi22.game.item;

import android.graphics.Bitmap;

public class Item {

    private String name;

    private Bitmap texture;

    public Item(String name, Bitmap texture) {
        this.name = name;
        this.texture = texture;
    }

    public String getName() {
        return name;
    }

    public Bitmap getTexture() {
        return texture;
    }
}