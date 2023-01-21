package edu.uoc.pacman.model.entities.items;

import edu.uoc.pacman.model.entities.Entity;
import edu.uoc.pacman.model.utils.Position;
import edu.uoc.pacman.model.utils.Sprite;

public abstract class MapItem extends Entity {

    public MapItem(boolean pathable, Position position, Sprite sprite) {
        super(pathable, position, sprite);
    }
}
