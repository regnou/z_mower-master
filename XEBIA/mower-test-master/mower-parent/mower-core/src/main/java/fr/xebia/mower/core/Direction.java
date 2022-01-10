package fr.xebia.mower.core;

import java.awt.Point;
import java.util.Arrays;
import java.util.List;

public enum Direction {

    NORTH, SOUTH, EAST, WEST;

    private static final List<Direction> ordereredDirections = Arrays.asList(NORTH, EAST, SOUTH, WEST);

    public static Direction getNextClockwiseDirection(Direction direction) {
        return getNextDirection(direction, 1);
    }

    public static Direction getNextCounterClockwiseDirection(Direction direction) {
        return getNextDirection(direction, -1);
    }

    private static Direction getNextDirection(Direction direction, int circularDirection) {
        if (direction == null) {
            throw new IllegalArgumentException("The direction can't be null");
        }
        int directionIndex = ordereredDirections.indexOf(direction);
        int nextDirectionIndex = (directionIndex + circularDirection) % ordereredDirections.size();
        if (nextDirectionIndex < 0) {
            nextDirectionIndex = ordereredDirections.size() + nextDirectionIndex;
        }
        return ordereredDirections.get(nextDirectionIndex);
    }

    public static Point getNextPoint(Direction direction, Point point) {
        int dx = 0;
        int dy = 0;
        switch (direction) {
        case NORTH:
            dy = 1;
            break;
        case SOUTH:
            dy = -1;
            break;
        case WEST:
            dx = -1;
            break;
        case EAST:
            dx = 1;
            break;
        default:
            throw new IllegalArgumentException("Invalid direction provided");
        }
        return new Point(point.x + dx, point.y + dy);
    }

    public static Direction fromChar(char ch) {
        for (Direction direction : values()) {
            if (direction.name().startsWith(ch + "")) {
                return direction;
            }
        }
        return null;
    }

}
