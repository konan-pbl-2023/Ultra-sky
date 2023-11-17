package com.example.prototypeapi22.game;

import com.example.prototypeapi22.game.entity.Entity;
import com.example.prototypeapi22.game.entity.EntityPlayer;
import com.example.prototypeapi22.game.stage.Stage;

public class GameSession {

    private GameState state;

    private long frames;
    private long elapsedTime; // milliseconds

    private Stage stage;

    public GameSession() {
        state = GameState.STANDBY;
        frames = 0L;
        elapsedTime = 0L;
        stage = new Stage();
    }

    public void update() {
        switch (state) {
            case STANDBY: {
                int waitTime = 3; // 3 seconds
                if (frames >= Game.FPS * waitTime) {
                    state = GameState.PLAYING;
                }
                break;
            }
            case PLAYING: {
                stage.update();

                updateTime();
                break;
            }
            case FINISHED: {
                break;
            }
        }
        countFrames();
    }

    private void updateTime() {
        elapsedTime += 1000 / Game.FPS;
    }

    private void countFrames() {
        frames++;
    }

    public GameState getState() {
        return state;
    }

    public long getElapsedTime() {
        return elapsedTime;
    }

    public Stage getStage() {
        return stage;
    }
}