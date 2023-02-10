package edu.uoc.pacman.model.entities.characters.pacman;

import edu.uoc.pacman.model.Level;
import edu.uoc.pacman.model.entities.characters.Character;
import edu.uoc.pacman.model.entities.characters.ghosts.Behaviour;
import edu.uoc.pacman.model.entities.characters.ghosts.Ghost;
import edu.uoc.pacman.model.entities.items.*;
import edu.uoc.pacman.model.utils.Direction;
import edu.uoc.pacman.model.utils.Position;
import edu.uoc.pacman.model.utils.Sprite;

import java.util.List;


public class Pacman extends Character {

    private State state;

    public Pacman(Position startPosition, Direction direction, State state, Level level) {
        super(startPosition, Sprite.PACMAN_UP, direction, level);
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        if (state != null) {
            this.state = state;
        }
    }

    private void nextState() {

        this.setDuration(this.getDuration() - 1);
        if (this.getDuration() == 0 && this.getState() != State.NORMAL) {
            this.setState(State.NORMAL);
            this.setDuration(this.getState().getDuration());
        }

    }

    private void eat() {
        MapItem item = this.getLevel().getMapItem(this.getPosition());

        if (item instanceof Pickable) {
            if (item instanceof Dot) {
                Dot dot = (Dot) item;
                dot.setPicked(true);
                this.getLevel().addPoints(dot.getPoints());

            } else if (item instanceof Energizer) {
                Energizer energizer = (Energizer) item;
                energizer.setPicked(true);
                this.getLevel().addPoints(energizer.getPoints());
                this.getLevel().setGhostsFrightened();
                this.setState(State.EATER);

            } else if (item instanceof Life) {
                Life life = (Life) item;
                life.setPicked(true);
                this.getLevel().increaseLives();
            }
            this.getLevel().removeMapItem(item);
            this.getLevel().addMapItem(new Path(this.getPosition()));
        }


    }

    @Override
    public void setDirection(Direction direction) {
        super.setDirection(direction);
        if (direction == null){
            return;
        }

        switch (direction) {
            case UP -> this.setSprite(Sprite.PACMAN_UP);
            case DOWN -> this.setSprite(Sprite.PACMAN_DOWN);
            case LEFT -> this.setSprite(Sprite.PACMAN_LEFT);
            case RIGHT -> this.setSprite(Sprite.PACMAN_RIGHT);
        }

    }

    @Override
    public void reset() {
        super.reset();
        this.setState(State.INVINCIBLE);
        this.setDirection(Direction.UP);
    }

    @Override
    public void move() {

        int newX = this.getPosition().getX() + this.getDirection().getX();
        int newY = this.getPosition().getY() + this.getDirection().getY();
        Position newPosition = new Position(newX, newY);


        if (this.getLevel().isPathable(newPosition)) {
            this.setPosition(newPosition);
        }

        this.hit();
        this.eat();
        this.nextState();

    }

    @Override
    public boolean hit() {
        if (this.getState() == State.INVINCIBLE) {
            return false;

        } else {
            List<Ghost> ghostList = this.getLevel().getGhostList();
            for (Ghost ghost : ghostList) {
                if (this.getPosition().equals(ghost.getPosition())) {
                    if (ghost.getBehaviour().equals(Behaviour.FRIGHTENED)) {
                        ghost.kill();
                        return true;
                    }else if (!ghost.getBehaviour().equals(Behaviour.INACTIVE)){
                        this.kill();
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public void kill() {
        super.kill();
        this.getLevel().decreaseLives();
        this.setState(State.INVINCIBLE);
    }

}
