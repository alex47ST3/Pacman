package edu.uoc.pacman.model.entities.items;

import edu.uoc.pacman.model.utils.Position;
import edu.uoc.pacman.model.utils.Sprite;

public class Dot extends MapItem{
    private boolean picked;
    private static final int POINTS = 1;

    public Dot(Position position) {
        super(true, position, Sprite.DOT);
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
