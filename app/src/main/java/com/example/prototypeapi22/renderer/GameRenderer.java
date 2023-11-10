package com.example.prototypeapi22.renderer;

import android.graphics.Canvas;

public class GameRenderer {

    private static GameRenderer instance = null;

    private GameRenderer() {
    }

    public void render(Canvas c) {
        // 描画処理をここに書く
        GameHud.renderHud(c);
    }

    public static GameRenderer getInstance() {
        if (instance == null) {
            instance = new GameRenderer();
        }
        return instance;
    }
}
