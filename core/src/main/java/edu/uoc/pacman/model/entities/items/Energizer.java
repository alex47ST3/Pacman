package edu.uoc.pacman.model.entities.items;

import edu.uoc.pacman.model.utils.Position;
import edu.uoc.pacman.model.utils.Sprite;

public class Energizer extends MapItem{
    private boolean picked;
    private static final int POINTS = 5;

    public Energizer(Position position) {
        super(true, position, Sprite.ENERGIZER);
    }

    public int getPoints(){
        return this.POINTS;
    }

    public boolean isPicked() {
        return picked;
    }

    public void setPicked(boolean picked) {
        this.picked = picked;
    }

}
