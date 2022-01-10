package fr.xebia.mower.core;

import java.awt.Point;

public class MowerState {

    private Point position;
    private Direction direction;

    public MowerState(Point position, Direction direction) {
        if (position == null || direction == null) {
            throw new IllegalArgumentException("The position and the direction must not be null");
        }
        this.position = position;
        this.direction = direction;
    }

    public Point getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null || !(other instanceof MowerState)) {
            return false;
        }
        MowerState mowerState = (MowerState) other;
        return position.equals(mowerState.position) && direction.equals(mowerState.direction);
    }

}
