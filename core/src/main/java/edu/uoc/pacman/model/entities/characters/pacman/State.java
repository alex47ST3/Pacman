package edu.uoc.pacman.model.entities.characters.pacman;

public enum State {

    NORMAL(Integer.MAX_VALUE),
    EATER(30),
    INVINCIBLE(5);


    private int duration;

    State(int duration) {
        this.duration=duration;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return this.name() + ":" + this.getDuration();
    }

}
