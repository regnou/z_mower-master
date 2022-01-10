package com.mowitnow.automation.mowing;

import com.mowitnow.automation.mowing.communication.CommunicationAware;
import com.mowitnow.automation.mowing.communication.Communicator;
import com.mowitnow.automation.mowing.move.UnexpectedMoveException;
import com.mowitnow.automation.mowing.move.Move;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Define a mower object
 */
public class Mower implements CommunicationAware {

    private static Logger LOG = LoggerFactory.getLogger(Mower.class);

    /**
     * Id of the mower
     */
    private int number = -1;

    /**
     * Mower position on the grid
     */
    private Position position;
    /**
     * Mower orientation
     */
    private Orientation orientation;
    /**
     * List of mower moves on the grid
     */
    private List<Move> moves = new ArrayList<Move>();


    public Mower(Position initialPosition, char orientation) {
        position = initialPosition;
        this.orientation = Orientation.fromCardinalPoint(orientation);
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    /**
     * Mow the given lawn with this mower
     *
     * @param lawn to mow
     */
    public void mow(Lawn lawn) {
        for(Move move : moves) {
            try {
                move.execute(this, lawn.getGrid());
            } catch (UnexpectedMoveException e) {
                LOG.warn(e.getMessage());
            }
        }
    }

    /**
     * Retrieve the current mower full position
     *  - position
     *  - orientation
     *
     * @return the position of the mower
     */
    public String getFullPosition() {
        return position + "," + orientation.getCardinalPoint();
    }

    @Override
    public void communicate(Communicator communicator) {
        StringBuilder message = new StringBuilder("Mower");
        message.append(this.number);
        message.append(": ");
        message.append(this.getFullPosition());

        communicator.send(message.toString());
    }
}
