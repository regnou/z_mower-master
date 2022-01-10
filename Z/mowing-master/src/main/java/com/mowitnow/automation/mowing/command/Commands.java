package com.mowitnow.automation.mowing.command;

import java.util.ArrayList;
import java.util.List;

/**
 * Define the list of commands to play for program setup
 */
public class Commands extends ArrayList<Command> {

    private int mowSetupCursor = 1;
    private int mowMovesCursor = 2;

    public Command getGridSetup() {
        Command command = null;
        if(this.size() > 0) {
            command = this.get(0);
        }
        return command;
    }

    public boolean hasNextMow() {
        return mowSetupCursor < this.size();
    }

    public Command nextMowSetup() {
        Command command = this.get(mowSetupCursor);
        mowSetupCursor += 2;
        return command;
    }

    public Command nextMowMoves() {
        Command command = this.get(mowMovesCursor);
        if(mowMovesCursor < mowSetupCursor) {
            mowMovesCursor = mowSetupCursor + 1;
        }
        return command;
    }

    public Commands(List<String> commands) {
        for(String command : commands) {
            this.add(new Command(command));
        }
    }

}
