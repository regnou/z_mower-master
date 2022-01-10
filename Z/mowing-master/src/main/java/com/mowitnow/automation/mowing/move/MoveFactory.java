package com.mowitnow.automation.mowing.move;

/**
 * Move builder
 */
public class MoveFactory {

    public static Move getMove(char command) {
        Move move = null;
        switch(command) {
            case 'A':
                move = new Forward();
                break;
            case 'D':
                move = new Right();
                break;
            case 'G':
                move = new Left();
                break;
        }
        return move;
    }

}
