package com.mowitnow.automation;

import com.mowitnow.automation.mowing.Grid;
import com.mowitnow.automation.mowing.command.Commands;
import com.mowitnow.automation.mowing.command.parser.GridCommandParser;
import com.mowitnow.automation.mowing.command.parser.MoveCommandParser;
import com.mowitnow.automation.mowing.command.parser.MowerCommandParser;
import com.mowitnow.automation.mowing.command.parser.ParseException;
import com.mowitnow.automation.mowing.communication.Communicator;
import com.mowitnow.automation.mowing.move.Move;
import com.mowitnow.automation.mowing.Lawn;
import com.mowitnow.automation.mowing.InvalidPositionException;
import com.mowitnow.automation.mowing.Mower;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Define the service to mow the lawn
 *
 * Singleton
 */
public class MowingService {

    private static Logger LOG = LoggerFactory.getLogger(MowingService.class);

    private static MowingService instance;

    public static MowingService getInstance() {
        if(null == instance) {
            instance = new MowingService();
        }
        return instance;
    }

    private MowingService() {}

    /**
     * Prepare lawn to be mowed from commands
     *
     * @param commands (instructions)
     * @return the lawn
     */
    public Lawn initLawn(Commands commands) {
        Lawn lawn = null;
        try {
            Grid grid = new GridCommandParser().parse(commands.getGridSetup());
            lawn = new Lawn(grid);

            while(commands.hasNextMow()) {
                try {
                    Mower mow = new MowerCommandParser().parse(commands.nextMowSetup());
                    List<Move> moves = new MoveCommandParser().parse(commands.nextMowMoves());
                    mow.setMoves(moves);
                    lawn.addMower(mow);
                } catch(ParseException | InvalidPositionException e) {
                    // do not add mow if commands parsing failed
                    LOG.warn(e.getMessage());
                }
            }
        } catch (ParseException e) {
            LOG.error(ExceptionUtils.getStackTrace(e));
        }
        return lawn;
    }

    /**
     * Mow the lawn with the defined mowers
     *
     * @param lawn to mow
     * @param communicator to send mowers' final position
     */
    public void mow(Lawn lawn, Communicator communicator) {
        for(Mower mower : lawn.getMowers()) {
            mower.mow(lawn);
            mower.communicate(communicator);
        }
    }


}
