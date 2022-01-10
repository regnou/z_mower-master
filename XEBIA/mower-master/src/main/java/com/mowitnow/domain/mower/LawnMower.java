package com.mowitnow.domain.mower;

import static com.mowitnow.domain.mower.Orientation.NORTH;

/**
 * Default {@link com.mowitnow.domain.mower.Mower} implementation.
 */
public class LawnMower implements Mower {

    private int x;
    private int y;
    private Orientation orientation = NORTH;

    public LawnMower(int x, int y, Orientation orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    @Override
    public void move() {
        switch (orientation) {
            case NORTH:
                y++;
                break;
            case SOUTH:
                y--;
                break;
            case EAST:
                x++;
                break;
            case WEST:
                x--;
                break;
            default:
                throw new UnsupportedOperationException("Cannot move according to unknown orientation : " + orientation);
        }
    }

    @Override
    public void rotateLeft() {
        orientation = orientation.getLeftOrientation();
    }

    @Override
    public void rotateRight() {
        orientation = orientation.getRightOrientation();
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public Orientation getOrientation() {
        return orientation;
    }

    @Override
    public String toString() {
        return "LawnMower{" +
                "x=" + x +
                ", y=" + y +
                ", orientation=" + orientation +
                '}';
    }
}
