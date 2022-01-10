package fr.xebia.mower.core;

import java.awt.Point;

public class Mower {

    private Point currentPosition;

    private Direction currentDirection;

    /**
     * Constructs a mower positioned at (0,0) and facing North
     */
    public Mower() {
        this(new Point(0, 0), Direction.NORTH);
    }

    /**
     * Constructs a mower at the provided initial position and facing North
     * 
     * @param initialPosition
     */
    public Mower(Point initialPosition) {
        this(initialPosition, Direction.NORTH);
    }

    public Mower(MowerState mowerState) {
        this(mowerState.getPosition(), mowerState.getDirection());
    }

    /**
     * Constructs a mower places at the given position and facing the given
     * direction
     * 
     * @param initialPosition
     * @param initialDirection
     */
    public Mower(Point initialPosition, Direction initialDirection) {
        this.currentPosition = new Point(initialPosition);
        this.currentDirection = initialDirection;
    }

    public void setPosition(Point position) {
        if (position == null) {
            throw new IllegalArgumentException("The position can't be null");
        }
        this.currentPosition = position;
    }

    public void setDirection(Direction direction) {
        if (direction == null) {
            throw new IllegalArgumentException("The direction can't be null");
        }
        this.currentDirection = direction;
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public Point getCurrentPosition() {
        return new Point(currentPosition);
    }

    public MowerState getCurrentMowerState() {
        return new MowerState(currentPosition, currentDirection);
    }

}
