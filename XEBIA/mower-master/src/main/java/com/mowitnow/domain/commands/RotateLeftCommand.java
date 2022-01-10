package com.mowitnow.domain.commands;

import com.mowitnow.domain.mower.Mower;

/**
 * {@link com.mowitnow.domain.commands.Command} for rotating the mower (i.e receiver object) 90 degrees to the left.
 */
public class RotateLeftCommand implements Command {

    private final Mower mower;

    public RotateLeftCommand(Mower mower) {
        this.mower = mower;
    }

    @Override
    public void execute() {
        mower.rotateLeft();
    }
}
