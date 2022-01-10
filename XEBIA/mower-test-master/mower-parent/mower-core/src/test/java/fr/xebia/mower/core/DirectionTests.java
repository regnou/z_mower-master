package fr.xebia.mower.core;

import static org.junit.Assert.assertTrue;

import java.awt.Point;

import org.junit.Test;

public class DirectionTests {

    private void testNextPoint(Direction direction, Point source, Point expected) {
        assertTrue(Direction.getNextPoint(direction, source).equals(expected));
    }

    @Test
    public void testDirectionNextPoint() {
        testNextPoint(Direction.NORTH, new Point(0, 0), new Point(0, 1));
        testNextPoint(Direction.SOUTH, new Point(0, 1), new Point(0, 0));
        testNextPoint(Direction.WEST, new Point(1, 0), new Point(0, 0));
        testNextPoint(Direction.EAST, new Point(0, 0), new Point(1, 0));
    }

    private void testClockwiseRotation(Direction source, Direction expected) {
        assertTrue(Direction.getNextClockwiseDirection(source).equals(expected));
    }

    @Test
    public void testDirectionClockwiseRotation() {
        testClockwiseRotation(Direction.NORTH, Direction.EAST);
        testClockwiseRotation(Direction.EAST, Direction.SOUTH);
        testClockwiseRotation(Direction.SOUTH, Direction.WEST);
        testClockwiseRotation(Direction.WEST, Direction.NORTH);
    }

    private void testCounterClockwiseRotation(Direction source, Direction expected) {
        assertTrue(Direction.getNextCounterClockwiseDirection(source).equals(expected));
    }

    @Test
    public void testDirectionCounterClockwiseRotation() {
        testCounterClockwiseRotation(Direction.NORTH, Direction.WEST);
        testCounterClockwiseRotation(Direction.WEST, Direction.SOUTH);
        testCounterClockwiseRotation(Direction.SOUTH, Direction.EAST);
        testCounterClockwiseRotation(Direction.EAST, Direction.NORTH);
    }

}
