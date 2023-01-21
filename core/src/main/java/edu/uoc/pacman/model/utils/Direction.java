package edu.uoc.pacman.model.utils;

public enum Direction {

    DOWN(0,1,20),
    RIGHT(-1,0,21),
    LEFT(1,0,22),
    UP(0,-1,19);


    private int x;
    private int y;
    private int keyCode;

    Direction(int x, int y, int keyCode) {
        this.x = x;
        this.y = y;
        this.keyCode = keyCode;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getKeyCode() {
        return keyCode;
    }

    public static Direction getDirectionByKeyCode(int keyCode){
        for (Direction direction : values()) {
            if (direction.getKeyCode() == keyCode) {
                return direction;
            }
        }
        return null;
    }

    public Direction opposite(){
        switch (this) {
            case UP:
                return DOWN;
            case DOWN:
                return UP;
            case LEFT:
                return RIGHT;
            case RIGHT:
                return LEFT;
    }
        return null;
    }


}
