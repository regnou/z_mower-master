package com.mowitnow.automation.mowing;

/**
 * Define the position of the lawn
 */
public class Grid {

    /**
     * Origin point
     */
    private Position origin;
    /**
     * End point
     */
    private Position end;


    public Grid(Position origin, Position end) {
        this.origin = origin;
        this.end = end;
    }

    /**
     * Check if the given point belongs to the grid
     *
     * @param position to check
     * @return boolean
     */
    public boolean isPositionValid(Position position) {
        return !(null == position || origin.getX() > position.getX() || end.getX() < position.getX()
                || origin.getY() > position.getY() || end.getY() < position.getY());
    }


    @Override
    public String toString() {
        return origin.toString() + "," + end.toString();
    }
}
