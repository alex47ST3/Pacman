package edu.uoc.pacman.model.entities.characters.ghosts.chase;

import edu.uoc.pacman.model.entities.characters.ghosts.Ghost;
import edu.uoc.pacman.model.utils.Direction;
import edu.uoc.pacman.model.utils.Position;

public class ChasePatrol  implements ChaseBehaviour{
    private static final int TILES_OFFSET=-2;
    private static final int VECTOR_INCREASE=2;

    public ChasePatrol() {
    }

    @Override
    public Position getChasePosition(Ghost ghost) {

        Position pacmanPosition = ghost.getLevel().getPacman().getPosition();
        Direction pacmanDirection = ghost.getLevel().getPacman().getDirection();

        int targetX = pacmanPosition.getX() + pacmanDirection.getX() * TILES_OFFSET;
        int targetY = pacmanPosition.getY() + pacmanDirection.getY() * TILES_OFFSET;

        Position targetBlinky = new Position(targetX, targetY);

        Position firstBlinky = ghost.getLevel().getBlinky().getPosition();

        int x = (targetBlinky.getX() - firstBlinky.getX())*VECTOR_INCREASE;
        int y = (targetBlinky.getY() - firstBlinky.getY())*VECTOR_INCREASE;

        return new Position(firstBlinky.getX()+x, firstBlinky.getY()+y);
    }


}
