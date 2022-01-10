package com.mowitnow.automation;

import com.mowitnow.automation.mowing.command.CommandLoadingException;
import com.mowitnow.automation.mowing.command.Commands;
import com.mowitnow.automation.mowing.command.CommandsLoader;
import com.mowitnow.automation.mowing.Lawn;
import com.mowitnow.automation.mowing.Mower;
import com.mowitnow.automation.mowing.communication.Communicator;
import com.mowitnow.automation.mowing.communication.CommunicatorFactory;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

public class AppTest {

    private MowingService service = MowingService.getInstance();

    @Test
    public void should_mow_the_grid() {
        try {
            InputStream stream = this.getClass().getResourceAsStream("/data/automation.txt");
            Commands commands = CommandsLoader.load(stream);
            Lawn lawn = service.initLawn(commands);
            Communicator communicator = CommunicatorFactory.getCommunicator(null);
            service.mow(lawn, communicator);

            List<Mower> mows = lawn.getMowers();
            assertEquals("(1;3),N", mows.get(0).getFullPosition());
            assertEquals("(5;1),E", mows.get(1).getFullPosition());

        } catch(CommandLoadingException e) {
            e.printStackTrace();
            fail();
        }
    }

}
