package com.mowitnow.automation.mowing.communication;

/**
 * Communicator builder
 */
public class CommunicatorFactory {

    /**
     * Retrieve communicator from input
     *
     * @param type of communicator
     * @return the instance of the communicator
     */
    public static Communicator getCommunicator(String type) {
        Communicator communicator = null;
        switch(CommunicatorType.fromInput(type)) {
            case CONSOLE:
                communicator = new ConsoleCommunicator();
                break;
        }

        return communicator;
    }

}
