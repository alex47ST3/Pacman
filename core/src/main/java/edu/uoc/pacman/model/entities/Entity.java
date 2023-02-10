package edu.uoc.pacman.model.entities;

import edu.uoc.pacman.model.utils.Position;
import edu.uoc.pacman.model.utils.Sprite;

public abstract class Entity {
    private boolean pathable;
    private Position position;
    private Sprite sprite;

    protected Entity(Position position, boolean pathable,  Sprite sprite) {
        this.pathable = pathable;
        this.position = position;
        this.sprite = sprite;
    }

    public boolean isPathable() {
        return pathable;
    }

    public void setPathable(boolean pathable) {
        this.pathable = pathable;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Sprite getSprite() {
        return sprite;
    }

    protected void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }
}
