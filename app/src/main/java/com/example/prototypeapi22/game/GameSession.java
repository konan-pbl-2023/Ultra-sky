package com.example.prototypeapi22.game;

import com.example.prototypeapi22.game.stage.Stage;

public class GameSession {

    private GameState state;

    private long frames;
    private long elapsedTime; // milliseconds

    private final Stage stage;

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
                // Go to result screen
                break;
            }
            case GAME_OVER: {
                // Go to result screen with replacing heading text
                break;
            }
        }
        countFrames();
    }

    public void onSwipe(float distX) {
        stage.onSwipe(distX);
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

    public GameState getGameState() {
        return state;
    }

    public void setGameState(GameState state) {
        this.state = state;
    }

    public long getElapsedTime() {
        return elapsedTime;
    }

    public Stage getStage() {
        return stage;
    }
}