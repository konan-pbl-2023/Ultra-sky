package com.example.prototypeapi22.game.stage;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import com.example.prototypeapi22.R;
import com.example.prototypeapi22.game.Game;
import com.example.prototypeapi22.game.GameHud;
import com.example.prototypeapi22.game.GameSession;

public class StageRenderer {

    private static StageRenderer instance = null;

    private Bitmap bgImage;

    private StageRenderer() {
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
    }

    public static StageRenderer getInstance() {
        if (instance == null) {
            instance = new StageRenderer();
        }
        return instance;
    }
}
