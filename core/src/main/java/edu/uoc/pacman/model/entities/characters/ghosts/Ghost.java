package edu.uoc.pacman.model.entities.characters.ghosts;

import edu.uoc.pacman.model.Level;
import edu.uoc.pacman.model.entities.Scorable;
import edu.uoc.pacman.model.entities.characters.Character;
import edu.uoc.pacman.model.entities.characters.ghosts.chase.ChaseBehaviour;
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
        this.behaviour = behaviour;
    }

    public ChaseBehaviour getChaseBehaviour() {
        return chaseBehaviour;
    }

    public void setScatterPosition(Position scatterPosition) {
        this.scatterPosition = scatterPosition;
    }

    public Position getScatterPosition(){
        return new Position(0,0)
    }
}
