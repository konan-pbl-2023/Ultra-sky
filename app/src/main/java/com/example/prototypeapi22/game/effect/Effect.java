package com.example.prototypeapi22.game.effect;

public class Effect {

    private final String name;

    private long duration;

    public Effect(String name, long duration) {
        this.name = name;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }
}
