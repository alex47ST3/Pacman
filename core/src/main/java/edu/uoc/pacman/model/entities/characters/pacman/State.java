package edu.uoc.pacman.model.entities.characters.pacman;

public enum State {

    NORMAL(5),
    EATER(Integer.MAX_VALUE),
    INVINCIBLE(30);


    private int duration;

    State(int duration) {
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return this.name() + ":" + this.getDuration();
    }

}
