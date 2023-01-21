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

    public Ghost(Position position, Sprite sprite, Direction direction, Level level, Behaviour behaviour, ChaseBehaviour chaseBehaviour, Position scatterPosition) {
        super(position, sprite, direction, level);
        this.behaviour = behaviour;
        this.chaseBehaviour = chaseBehaviour;
        this.scatterPosition = scatterPosition;
    }

    public Position getScatterPosition(){
        return new Position(0,0)
    }
}
