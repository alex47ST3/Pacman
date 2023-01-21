package edu.uoc.pacman.model.entities.characters.pacman;

import edu.uoc.pacman.model.Level;
import edu.uoc.pacman.model.entities.characters.Character;
import edu.uoc.pacman.model.utils.Direction;
import edu.uoc.pacman.model.utils.Position;
import edu.uoc.pacman.model.utils.Sprite;

public class Pacman extends Character {

    public Pacman(Position position, Sprite sprite, Direction direction, Level level) {
        super(position, sprite, direction, level);
    }

    public Position getPosition() {
        return new Position(0,0);
    }

    @Override
    public boolean hit() {
        return false;
    }

    @Override
    public void move() {

    }
}
