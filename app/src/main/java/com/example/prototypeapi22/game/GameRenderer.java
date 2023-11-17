package com.example.prototypeapi22.game;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import com.example.prototypeapi22.R;

public class GameRenderer {

    private static GameRenderer instance = null;

    private Bitmap bgImage;

    private GameRenderer() {
    }

    public void render(Canvas c) {
        // Do not render unless game session exists
        GameSession session = Game.getInstance().getGameSession();
        if (session == null) {
            return;
        }

        // Render background
        if (bgImage == null) {
            bgImage = Game.getInstance().getResourceLoader().getResource(R.drawable.cloud_bg);
        }
        Rect src = new Rect(0, 0, bgImage.getWidth(), bgImage.getHeight());
        Rect dest = new Rect(0, 0, c.getWidth(), c.getHeight());
        c.drawBitmap(bgImage, src, dest, null);

        // Render entities
        session.getStage().draw(c);

        GameHud.renderHud(c);
    }

    public static GameRenderer getInstance() {
        if (instance == null) {
            instance = new GameRenderer();
        }
        return instance;
    }
}
