package edu.uoc.pacman.model.entities.characters.ghosts;

import edu.uoc.pacman.model.Level;
import edu.uoc.pacman.model.entities.Scorable;
import edu.uoc.pacman.model.entities.characters.Character;
import edu.uoc.pacman.model.entities.characters.ghosts.chase.ChaseBehaviour;
import edu.uoc.pacman.model.entities.characters.pacman.State;
import edu.uoc.pacman.model.utils.Direction;
import edu.uoc.pacman.model.utils.Position;
import edu.uoc.pacman.model.utils.Sprite;

public abstract class Ghost extends Character implements Scorable {
    private Behaviour behaviour;
    protected ChaseBehaviour chaseBehaviour;
    private Position scatterPosition;

    protected Ghost(Position startPosition, Position scatterPosition, Direction direction,
                    Behaviour behaviour, Sprite sprite, Level level) {
        super(startPosition, sprite, direction, level);
        setBehaviour(behaviour);
        setScatterPosition(scatterPosition);
    }

    public Behaviour getBehaviour() {
        return behaviour;
    }

    public void setBehaviour(Behaviour behaviour) {
        if (behaviour != null) {
            this.behaviour=behaviour;
            this.setDuration(behaviour.getDuration());
        }

    }

    private void nextBehaviour() {
        this.setDuration(this.getDuration() - 1);

        if (this.getDuration() == 0 && this.getBehaviour() == Behaviour.CHASE) {
            this.setBehaviour(Behaviour.SCATTER);
            this.setDuration(Behaviour.SCATTER.getDuration());
        } else {
            this.setBehaviour(Behaviour.CHASE);
            this.setDuration(Behaviour.CHASE.getDuration());
        }

    }

    private void setScatterPosition(Position scatterPosition) {
        this.scatterPosition = scatterPosition;
    }

    public Position getScatterPosition() {
        return this.scatterPosition;
    }

    private Position getTargetPosition() {
        if (this.getBehaviour().equals(Behaviour.CHASE)) {
            return chaseBehaviour.getChasePosition(this);
        }else if (this.getBehaviour().equals(Behaviour.SCATTER) ||
                this.getBehaviour().equals(Behaviour.FRIGHTENED))  {
            return this.getScatterPosition();
        }else{
            return null;
        }
    }

    @Override
    public void move() {

        if (this.getTargetPosition() == null) {
            nextBehaviour();
            return;
        }

        double minDistance = Double.MAX_VALUE;
        Direction newDirection = this.getDirection();
        Position newPosition;

        for (Direction direction : Direction.values()) {

            int newX = this.getPosition().getX() + direction.getX();
            int newY = this.getPosition().getY() + direction.getY();
            newPosition = new Position(newX, newY);
            double newDistance = newPosition.distance(this.getTargetPosition());

            if (newDistance <= minDistance
                    && this.getLevel().isPathable(newPosition)
                    && !this.getDirection().opposite().equals(direction)
            ) {
                minDistance = newDistance;
                newDirection = direction;
            }
        }

        this.setDirection(newDirection);

        Position nextPosition = new Position(newDirection.getX(),newDirection.getY());
        nextPosition = Position.add(this.getPosition(), nextPosition);
        this.setPosition(nextPosition);
        hit();
        nextBehaviour();

    }

    @Override
    public boolean hit() {
        Position pacmanPosition = this.getLevel().getPacman().getPosition();
        State pacmanState = this.getLevel().getPacman().getState();

        if (this.getPosition().equals(pacmanPosition)
                && !this.getBehaviour().equals(Behaviour.INACTIVE)
                && (this.getBehaviour().equals(Behaviour.FRIGHTENED)
                || pacmanState.equals(State.INVINCIBLE))
        ){
            this.kill();
            return true;
        } else if (this.getPosition().equals(pacmanPosition)
                && !this.getBehaviour().equals(Behaviour.INACTIVE)
                && pacmanState.equals(State.NORMAL)
        ) {
            this.getLevel().getPacman().kill();
            return true;
        }else return false;
    }

    @Override
    public void kill() {
        super.kill();
        this.getLevel().addPoints(this.getPoints());
        this.setBehaviour(Behaviour.INACTIVE);
    }

    @Override
    public void reset() {
        super.reset();
        this.setBehaviour(Behaviour.INACTIVE);
        this.setDirection(Direction.UP);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Ghost) {
            Ghost ghost = (Ghost) o;
            return (this.isDead() == ghost.isDead()
                    && this.getBehaviour().equals(ghost.getBehaviour())
                    && this.getDirection().equals(ghost.getDirection())
                    && this.getPosition().equals(ghost.getPosition())
                    && this.getDuration() == ghost.getDuration());

        } else {
            return false;
        }
    }

    @Override
    public String toString(){
        return this.getPosition().getX() + "," + this.getPosition().getY() +
                "," + this.getDirection().name() + "," + this.getBehaviour().toString() ;
    }

}
