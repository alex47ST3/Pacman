package edu.uoc.pacman.model.utils;

import java.util.Objects;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        setX(x);
        setY(y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object other){
        if(other instanceof Position ){
            Position position = (Position) other;
            Boolean condition = (this.getX() == position.getX()  && this.getY() == position.getY());
            return condition;
        } else{
            return false;
        }

    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public static Position add(Position p1, Position p2) throws NullPointerException{

        int x = p1.getX() + p2.getX();
        int y = p1.getY() + p2.getY();

        if(p1==null||p2==null){
            throw new NullPointerException();
        } else {
            return new Position(x,y);
        }
    }

    public double distance(Position other) {
        if (other == null) {
            return 0;
        }
        int distanceX = this.getX() - other.getX();
        int distanceY = this.getY() - other.getY();
        return Math.sqrt(Math.pow( distanceX, 2) + Math.pow(distanceY, 2));
    }
}