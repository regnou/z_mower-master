package com.mowitnow.automation.mowing;

import java.util.ArrayList;
import java.util.List;

/**
 * Define the grass surface to mow
 */
public class Lawn {

    /**
     * Division of the grass into elements
     */
    private Grid grid;
    /**
     * Mowers on the grass
     */
    private List<Mower> mowers = new ArrayList<Mower>();

    public Lawn(Grid grid) {
        this.grid = grid;
    }

    public Grid getGrid() {
        return grid;
    }

    public void addMower(Mower mower) {
        if(!grid.isPositionValid(mower.getPosition())) {
            throw new InvalidPositionException("Mower starting position is out of the grid");
        }

        if(null == mowers) {
            mowers = new ArrayList<Mower>();
        }
        mower.setNumber(mowers.size() + 1);
        mowers.add(mower);
    }

    public List<Mower> getMowers() {
        return mowers;
    }

}
