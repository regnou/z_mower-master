package com.mowitnow.automation.mowing;

public class Position {

    private int x = 0;
    private int y = 0;

    public Position() { }

    public Position(int x, int y) {
        setX(x);
        setY(y);
    }

    public Position(char x, char y) {
        this(Character.getNumericValue(x), Character.getNumericValue(y));
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        if(x < 0) {
            throw new InvalidPositionException("Invalid x value given: " + x);
        }
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        if(y < 0) {
            throw new InvalidPositionException("Invalid y value given: " + y);
        }
        this.y = y;
    }

    public void incrementX() {
        x++;
    }

    public void incrementY() {
        y++;
    }

    public void decrementX() {
        x--;
    }

    public void decrementY() {
        y--;
    }

    @Override
    public String toString() {
        return "(" + x + ";" + y + ")";
    }
}
