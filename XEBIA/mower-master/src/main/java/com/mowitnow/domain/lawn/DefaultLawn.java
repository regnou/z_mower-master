package com.mowitnow.domain.lawn;

/**
 * Default {@link com.mowitnow.domain.lawn.Lawn} implementation.
 */
public class DefaultLawn implements Lawn {

    private final int width;
    private final int height;

    public DefaultLawn(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }
}
