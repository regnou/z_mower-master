package com.mowitnow.domain.lawn;

/**
 * {@link com.mowitnow.domain.lawn.DefaultLawn} Fixtures
 */
public class DefaultLawnFixtures {

    /**
     * Create a square-like DefaultLawn of width 1 and height 1
     *
     * @return a new {@link com.mowitnow.domain.lawn.DefaultLawn}
     */
    public static DefaultLawn newDefaultLawn() {
        return newDefaultLawnOfGivenSize(1, 1);
    }

    private static DefaultLawn newDefaultLawnOfGivenSize(int width, int height) {
        return new DefaultLawn(width, height);
    }
}
