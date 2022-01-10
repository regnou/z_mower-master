package com.mowitnow.domain.commands;

import com.mowitnow.domain.lawn.Lawn;
import com.mowitnow.domain.mower.Mower;

/**
 * {@link com.mowitnow.domain.commands.Command} for moving the mower (i.e receiver object) forward onto the given {@link com.mowitnow.domain.lawn.Lawn}.
 */
public class MoveCommand implements Command {

    private final Mower mower;
    private final Lawn lawn;

    public MoveCommand(Mower mower, Lawn lawn) {
        this.mower = mower;
        this.lawn = lawn;
    }

    @Override
    public void execute() {
        if (mower.getY() < lawn.getHeight()) {
            mower.move();
        }
    }
}
