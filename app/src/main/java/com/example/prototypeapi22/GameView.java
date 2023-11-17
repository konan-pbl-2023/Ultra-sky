package com.example.prototypeapi22;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import androidx.annotation.NonNull;
import com.example.prototypeapi22.game.Game;
import com.example.prototypeapi22.game.GameState;

public class GameView extends SurfaceView implements SurfaceHolder.Callback, Runnable {

    private Thread thread;

    private final SurfaceHolder holder;

    public GameView(Context context) {
        super(context);

        holder = getHolder();
        holder.addCallback(this);
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
        Game.getInstance().init(getResources());

        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {
    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
        thread = null;

        Game.getInstance().destroy();
    }

    @Override
    public void run() {
        Canvas canvas;

        while (thread != null) {
            canvas = holder.lockHardwareCanvas();

            if (Game.fieldWidth == -1) {
                Game.fieldWidth = canvas.getWidth();
            }
            if (Game.fieldHeight == -1) {
                Game.fieldHeight = canvas.getHeight();
            }
            Game.getInstance().update();
            Game.getInstance().draw(canvas);

            holder.unlockCanvasAndPost(canvas);
        }
    }
}