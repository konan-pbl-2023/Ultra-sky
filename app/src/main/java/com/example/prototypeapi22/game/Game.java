package com.example.prototypeapi22.game;

import android.content.res.Resources;
import android.graphics.Canvas;

import com.example.prototypeapi22.game.renderer.GameRenderer;
import com.example.prototypeapi22.game.utils.ResourceLoader;

public class Game {

    private static Game instance = null;

    private ResourceLoader resourceLoader;

    private Game() {
    }

    public void init(Resources res) {
        resourceLoader = new ResourceLoader(res);

        // 初期化処理をここに書く
    }

    public void update() {
    }

    public void draw(Canvas c) {
        GameRenderer.getInstance().render(c);
    }

    public void destroy() {
        // 終了時の処理をここに書く
    }

    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}