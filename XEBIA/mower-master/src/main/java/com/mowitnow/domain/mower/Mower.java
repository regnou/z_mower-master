package com.mowitnow.domain.mower;

/**
 * This class represents a programmable and automated mower with the ability to mow any rectangular surface.
 */
public interface Mower {

    /**
     * Move this mower one position forward from its current position
     */
    public void move();

    /**
     * Rotate this mower 90 degrees to the left
     */
    public void rotateLeft();

    /**
     * Rotate this mower 90 degrees to the right
     */
    public void rotateRight();

    public int getX();
    public int getY();
    public Orientation getOrientation();
}
