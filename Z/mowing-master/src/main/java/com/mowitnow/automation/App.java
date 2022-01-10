package com.mowitnow.automation;

import com.mowitnow.automation.mowing.command.CommandLoadingException;
import com.mowitnow.automation.mowing.command.Commands;
import com.mowitnow.automation.mowing.command.CommandsLoader;
import com.mowitnow.automation.mowing.Lawn;
import com.mowitnow.automation.mowing.communication.Communicator;
import com.mowitnow.automation.mowing.communication.CommunicatorFactory;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class App {

    private static Logger LOG = LoggerFactory.getLogger(App.class);

    private static MowingService service = MowingService.getInstance();

    /**
     * Program entry point
     *
     * @param args
     *      - 0: automation data file (mandatory)
     *      - 1: communicator type (optional)
     *              - console
     */
    public static void main(String[] args) {
        if(args.length == 0) {
            throw new RuntimeException("Please provide automation data file path as argument");
        }

        try {
            Commands commands = CommandsLoader.load(new File(args[0]));
            Lawn lawn = service.initLawn(commands);
            Communicator communicator = CommunicatorFactory.getCommunicator((args.length == 2) ? args[1] : null);
            service.mow(lawn, communicator);

        } catch(CommandLoadingException e) {
            LOG.error(ExceptionUtils.getStackTrace(e));
        }
    }

}
