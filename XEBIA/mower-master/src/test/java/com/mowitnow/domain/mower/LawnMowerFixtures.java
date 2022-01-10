package com.mowitnow.domain.mower;

/**
 * {@link com.mowitnow.domain.mower.LawnMower} Fixtures
 */
public class LawnMowerFixtures {

    /**
     * Create a LawnMower at position [0, 0] facing North and return it
     *
     * @return a new {@link com.mowitnow.domain.mower.LawnMower}
     */
    public static LawnMower newLawnMowerAtDefaultInitialPositionFacingNorth() {
        return newLawnMowerAtGivenPositionFacingGivenOrientation(0, 0, Orientation.NORTH);
    }

    /**
     * Create a LawnMower at position [1, 1] facing South and return it
     *
     * @return a new {@link com.mowitnow.domain.mower.LawnMower}
     */
    public static LawnMower newLawnMowerAtCenterPositionFacingSouth() {
        return newLawnMowerAtCenterPositionFacingGivenOrientation(Orientation.SOUTH);
    }

    /**
     * Create a LawnMower at position [1, 1] facing East and return it
     *
     * @return a new {@link com.mowitnow.domain.mower.LawnMower}
     */
    public static LawnMower newLawnMowerAtCenterPositionFacingEast() {
        return newLawnMowerAtCenterPositionFacingGivenOrientation(Orientation.EAST);
    }

    /**
     * Create a LawnMower at position [1, 1] facing West and return it
     *
     * @return a new {@link com.mowitnow.domain.mower.LawnMower}
     */
    public static LawnMower newLawnMowerAtCenterPositionFacingWest() {
        return newLawnMowerAtCenterPositionFacingGivenOrientation(Orientation.WEST);
    }

    private static LawnMower newLawnMowerAtCenterPositionFacingGivenOrientation(Orientation orientation) {
        return newLawnMowerAtGivenPositionFacingGivenOrientation(1, 1, orientation);
    }

    /**
     * Create a LawnMower ar given position facing the given {@link com.mowitnow.domain.mower.Orientation}
     * @param x the x coordinate of the mower
     * @param y the y coordinate of the mower
     * @param orientation the orientation of the mower
     * @return a new {@link com.mowitnow.domain.mower.LawnMower}
     */
    public static LawnMower newLawnMowerAtGivenPositionFacingGivenOrientation(int x, int y, Orientation orientation) {
        return new LawnMower(x, y, orientation);
    }
}
