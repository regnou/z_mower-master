package com.mowitnow.automation.mowing.communication;

/**
 * Console implementation of communicator
 */
class ConsoleCommunicator implements Communicator {

    @Override
    public void send(String message) {
        System.out.println(message);
    }
}
