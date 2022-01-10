package com.mowitnow.automation.mowing.communication;

import org.junit.Test;

import static org.junit.Assert.*;

public class CommunicatorFactoryTest {

    @Test
    public void should_create_console_communicator() {
        Communicator communicator = CommunicatorFactory.getCommunicator("console");

        assertTrue(communicator instanceof ConsoleCommunicator);
    }

}
