package edu.uoc.pacman.model.utils;

public enum Sprite {
    BLINKY('B', "images/blinky.png"),
    CLYDE('P', "images/pinky.png"),
    DOT('I', "images/inky.png"),
    ENERGIZER('C', "images/clyde.png"),
    INKY('.', "images/dot.png"),
    LIFE('0', "images/energizer.png"),
    PACMAN_DOWN('#', "images/wall.png"),
    PACMAN_LEFT(' ', "images/path.png"),
    PACMAN_RIGHT('L', "images/life.png"),
    PACMAN_UP('V', "images/pac_down.png"),
    PATH('^', "images/pac_up.png"),
    PINKY('<', "images/pac_right.png"),
    WALL('>', "images/pac_left.png");

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
