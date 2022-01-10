package fr.xebia.mower.core;

import java.awt.Point;
import java.awt.Rectangle;

public class Grid {

    private Rectangle rectangle;
    private int width;
    private int height;

    public Grid(int width, int height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("The width and height must be greater than zero");
        }
        this.width = width;
        this.height = height;
        this.rectangle = new Rectangle(width + 1, height + 1);

    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isWithinBounds(Point point) {
        return rectangle.contains(point);
    }

    public boolean isWithinBounds(int x, int y) {
        return rectangle.contains(x, y);
    }

    @Override
    public boolean equals(Object other) {
        if (other == null || !(other instanceof Grid)) {
            return false;
        }
        Grid grid = (Grid) other;
        return width == grid.width && height == grid.height;
    }

}
