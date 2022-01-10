package com.mowitnow.automation.mowing;

/**
 * Mower orientation possibilities
 */
public enum Orientation {

    EAST('E'),
    WEST('W'),
    NORTH('N'),
    SOUTH('S');

    private char cardinalPoint;

    private Orientation(char initial) {
        this.cardinalPoint = initial;
    }

    public char getCardinalPoint() {
        return cardinalPoint;
    }

    public static Orientation fromCardinalPoint(char cardinalPoint) {
        for(Orientation orientation : values()) {
            if(orientation.cardinalPoint == cardinalPoint) {
                return orientation;
            }
        }
        throw new IllegalArgumentException("No orientation for cardinal point: " + cardinalPoint);
    }

}
