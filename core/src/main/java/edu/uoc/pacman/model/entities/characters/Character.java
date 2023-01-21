package edu.uoc.pacman.model.entities.characters;

import edu.uoc.pacman.model.Level;
import edu.uoc.pacman.model.entities.Entity;
import edu.uoc.pacman.model.utils.Direction;
import edu.uoc.pacman.model.utils.Position;
import edu.uoc.pacman.model.utils.Sprite;

public abstract class Character extends Entity implements Movable, Hitable{
    private boolean dead;
    private Direction direction;
    private int duration;
    private Level level;
    private Position startPosition;

    protected Character(Position position, Sprite sprite, Direction direction, Level level) {

        super(true, position, sprite);

        if(position==null){
            position = new Position(0,0);
        }
        setPosition(position);
        setStartPosition(position);

        if(direction==null){
            direction = Direction.UP;
        }
        setDirection(direction);

        this.alive();
        setLevel(level);
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public void alive() {
        this.dead = false;
    }

    public void kill() {
        this.dead = true;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Position getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(Position startPosition) {
        this.startPosition = startPosition;
    }

    public void reset(){
        setPosition(startPosition);
        setDirection(Direction.UP);
        alive();
        setDuration(0);
    }

    @Override
    public String toString(){
        return getPosition().getX() + "," + getPosition().getY() + "," + getDirection().name();
    }
}
