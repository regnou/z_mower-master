package com.mowitnow.domain.mower;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * {@link com.mowitnow.domain.mower.LawnMower} unit testing.
 */
@Test
public class LawnMowerTests {

    //~ MOVE ===========================================================================================================

    public void Given_MowerFacingNorth_When_ToldToMove_Then_StopOnAdjacentUpperPositionFacingNorth() {
        LawnMower lawnMower = LawnMowerFixtures.newLawnMowerAtDefaultInitialPositionFacingNorth();

        lawnMower.move();

        assertEquals(lawnMower.getX(), 0);
        assertEquals(lawnMower.getY(), 1);
        assertEquals(lawnMower.getOrientation(), Orientation.NORTH);
    }

    public void Given_MowerFacingSouth_When_ToldToMove_Then_StopOnAdjacentLowerPositionFacingSouth() {
        LawnMower lawnMower = LawnMowerFixtures.newLawnMowerAtCenterPositionFacingSouth();

        lawnMower.move();

        assertEquals(lawnMower.getX(), 1);
        assertEquals(lawnMower.getY(), 0);
        assertEquals(lawnMower.getOrientation(), Orientation.SOUTH);
    }

    public void Given_MowerFacingEast_When_ToldToMove_Then_StopOnAdjacentRightPositionFacingEast() {
        LawnMower lawnMower = LawnMowerFixtures.newLawnMowerAtCenterPositionFacingEast();

        lawnMower.move();

        assertEquals(lawnMower.getX(), 2);
        assertEquals(lawnMower.getY(), 1);
        assertEquals(lawnMower.getOrientation(), Orientation.EAST);
    }

    public void Given_MowerFacingWest_When_ToldToMove_Then_StopOnAdjacentLeftPositionFacingWest() {
        LawnMower lawnMower = LawnMowerFixtures.newLawnMowerAtCenterPositionFacingWest();

        lawnMower.move();

        assertEquals(lawnMower.getX(), 0);
        assertEquals(lawnMower.getY(), 1);
        assertEquals(lawnMower.getOrientation(), Orientation.WEST);
    }

    //~ ROTATE LEFT ====================================================================================================

    public void Given_MowerFacingEast_When_ToldToRotateLeft_Then_StopOnSamePositionFacingNorth() {
        LawnMower lawnMower = LawnMowerFixtures.newLawnMowerAtCenterPositionFacingEast();

        lawnMower.rotateLeft();

        assertEquals(lawnMower.getX(), 1);
        assertEquals(lawnMower.getY(), 1);
        assertEquals(lawnMower.getOrientation(), Orientation.NORTH);
    }

    public void Given_MowerFacingNorth_When_ToldToRotateLeft_Then_StopOnSamePositionFacingWest() {
        LawnMower lawnMower = LawnMowerFixtures.newLawnMowerAtDefaultInitialPositionFacingNorth();

        lawnMower.rotateLeft();

        assertEquals(lawnMower.getX(), 0);
        assertEquals(lawnMower.getY(), 0);
        assertEquals(lawnMower.getOrientation(), Orientation.WEST);
    }

    public void Given_MowerFacingSouth_When_ToldToRotateLeft_Then_StopOnSamePositionFacingEast() {
        LawnMower lawnMower = LawnMowerFixtures.newLawnMowerAtCenterPositionFacingSouth();

        lawnMower.rotateLeft();

        assertEquals(lawnMower.getX(), 1);
        assertEquals(lawnMower.getY(), 1);
        assertEquals(lawnMower.getOrientation(), Orientation.EAST);
    }

    public void Given_MowerFacingWest_When_ToldToRotateLeft_Then_StopOnSamePositionFacingSouth() {
        LawnMower lawnMower = LawnMowerFixtures.newLawnMowerAtCenterPositionFacingWest();

        lawnMower.rotateLeft();

        assertEquals(lawnMower.getX(), 1);
        assertEquals(lawnMower.getY(), 1);
        assertEquals(lawnMower.getOrientation(), Orientation.SOUTH);
    }

    //~ ROTATE RIGHT ===================================================================================================

    public void Given_MowerFacingEast_When_ToldToRotateRight_Then_StopOnSamePositionFacingSouth() {
        LawnMower lawnMower = LawnMowerFixtures.newLawnMowerAtCenterPositionFacingEast();

        lawnMower.rotateRight();

        assertEquals(lawnMower.getX(), 1);
        assertEquals(lawnMower.getY(), 1);
        assertEquals(lawnMower.getOrientation(), Orientation.SOUTH);
    }

    public void Given_MowerFacingNorth_When_ToldToRotateRight_Then_StopOnSamePositionFacingEast() {
        LawnMower lawnMower = LawnMowerFixtures.newLawnMowerAtDefaultInitialPositionFacingNorth();

        lawnMower.rotateRight();

        assertEquals(lawnMower.getX(), 0);
        assertEquals(lawnMower.getY(), 0);
        assertEquals(lawnMower.getOrientation(), Orientation.EAST);
    }

    public void Given_MowerFacingSouth_When_ToldToRotateRight_Then_StopOnSamePositionFacingWest() {
        LawnMower lawnMower = LawnMowerFixtures.newLawnMowerAtCenterPositionFacingSouth();

        lawnMower.rotateRight();

        assertEquals(lawnMower.getX(), 1);
        assertEquals(lawnMower.getY(), 1);
        assertEquals(lawnMower.getOrientation(), Orientation.WEST);
    }

    public void Given_MowerFacingWest_When_ToldToRotateRight_Then_StopOnSamePositionFacingNorth() {
        LawnMower lawnMower = LawnMowerFixtures.newLawnMowerAtCenterPositionFacingWest();

        lawnMower.rotateRight();

        assertEquals(lawnMower.getX(), 1);
        assertEquals(lawnMower.getY(), 1);
        assertEquals(lawnMower.getOrientation(), Orientation.NORTH);
    }
}
