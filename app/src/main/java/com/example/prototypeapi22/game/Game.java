package com.example.prototypeapi22.game;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import com.example.prototypeapi22.game.stage.StageRenderer;
import com.example.prototypeapi22.game.utils.ResourceLoader;

public class Game {

    public static final int FPS = 60;
    public static int fieldWidth = -1;
    public static int fieldHeight = -1;

    private static Game instance = null;

    private ResourceLoader resourceLoader;

    private GameSession gameSession;

    private Game() {
    }

    public void init(Resources res) {
        resourceLoader = new ResourceLoader(res);
        gameSession = new GameSession();
    }

    public void update() {
        gameSession.update();
    }

    public void draw(Canvas c) {
        // clear all previous bitmaps
        c.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);

        StageRenderer.getInstance().render(c);
        GameHud.renderHud(c);
    }

    public void destroy() {
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

    public GameSession getGameSession() {
        return gameSession;
    }
}