package edu.uoc.pacman.model.entities.characters.ghosts.chase;

import edu.uoc.pacman.model.entities.characters.ghosts.Ghost;
import edu.uoc.pacman.model.utils.Direction;
import edu.uoc.pacman.model.utils.Position;

public class ChaseAmbush implements ChaseBehaviour {

    private static final int TILES_OFFSET = -4;

    public ChaseAmbush() {
    }

    @Override
    public Position getChasePosition(Ghost ghost) {

        Position pacmanPosition = ghost.getLevel().getPacman().getPosition();
        Direction pacmanDirection = ghost.getLevel().getPacman().getDirection();

        int targetX = pacmanPosition.getX() + pacmanDirection.getX() * TILES_OFFSET;
        int targetY = pacmanPosition.getY() + pacmanDirection.getY() * TILES_OFFSET;

        return new Position(targetX, targetY);
    }
}
