package edu.uoc.pacman.model.entities.items;

import edu.uoc.pacman.model.utils.Position;
import edu.uoc.pacman.model.utils.Sprite;

public class Path extends MapItem {

    public Path(Position position) {
        super(true, position, Sprite.PATH);
    }
}
