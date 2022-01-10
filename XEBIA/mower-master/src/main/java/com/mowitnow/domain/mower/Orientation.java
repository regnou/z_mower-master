package com.mowitnow.domain.mower;

/**
 * This class identifies the 4 cardinal points as usually found in any orientation system.<br/>
 * It can be used to represent the orientation of any {@link com.mowitnow.domain.mower.Mower} object.
 */
public enum Orientation {

    NORTH,
    SOUTH,
    EAST,
    WEST;

    private Orientation leftOrientation;
    private Orientation rightOrientation;

    static {
        NORTH.leftOrientation = WEST;
        SOUTH.leftOrientation = EAST;
        EAST.leftOrientation = NORTH;
        WEST.leftOrientation = SOUTH;

        NORTH.rightOrientation = EAST;
        SOUTH.rightOrientation = WEST;
        EAST.rightOrientation = SOUTH;
        WEST.rightOrientation = NORTH;
    }

    /**
     * Return the orientation 90 degrees left from this orientation
     *
     * @return an {@link Orientation}
     */
    public Orientation getLeftOrientation() {
        return leftOrientation;
    }

    /**
     * Return the orientation 90 degrees right from this orientation
     *
     * @return an {@link Orientation}
     */
    public Orientation getRightOrientation() {
        return rightOrientation;
    }
}
