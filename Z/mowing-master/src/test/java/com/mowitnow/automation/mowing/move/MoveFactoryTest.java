package com.mowitnow.automation.mowing.move;

import org.junit.Test;

import static org.junit.Assert.*;

public class MoveFactoryTest {

    @Test
    public void should_build_forward_move() {
        Move move = MoveFactory.getMove('A');

        assertTrue(move instanceof Forward);
    }

    @Test
    public void should_build_left_move() {
        Move move = MoveFactory.getMove('G');

        assertTrue(move instanceof Left);
    }

    @Test
    public void should_build_right_move() {
        Move move = MoveFactory.getMove('D');

        assertTrue(move instanceof Right);
    }

}
