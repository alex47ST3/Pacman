package edu.uoc.pacman.model.entities.items;

import edu.uoc.pacman.model.utils.Position;
import edu.uoc.pacman.model.utils.Sprite;

public class Life extends MapItem implements Pickable{
    public Life(Position position) {
        super(true, position, Sprite.LIFE);
    }

    @Override
    public boolean isPicked() {
        return false;
    }

    @Override
    public void setPicked() {

    }
}
