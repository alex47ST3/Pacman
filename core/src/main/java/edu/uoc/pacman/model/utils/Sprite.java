package edu.uoc.pacman.model.utils;

public enum Sprite {
    BLINKY('B', "images/blinky.png"),
    PINKY('P', "images/pinky.png"),
    INKY('I', "images/inky.png"),
    CLYDE('C', "images/clyde.png"),
    DOT('.', "images/dot.png"),
    ENERGIZER('0', "images/energizer.png"),
    WALL('#', "images/wall.png"),
    PATH(' ', "images/path.png"),
    LIFE('L', "images/life.png"),
    PACMAN_DOWN('V', "images/pac_down.png"),
    PACMAN_UP('^', "images/pac_up.png"),
    PACMAN_RIGHT('<', "images/pac_right.png"),
    PACMAN_LEFT('>', "images/pac_left.png");

    private final String imageSrc;
    private final char symbol;

    Sprite(char symbol, String imageSrc) {
        this.imageSrc = imageSrc;
        this.symbol = symbol;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public char getSymbol() {
        return symbol;
    }


}
