package com.mowitnow.automation.mowing.communication;

/**
 * Define the ability of an object to communicate
 */
public interface CommunicationAware {

    /**
     * Communicate
     *
     * @param communicator is the mean of communication (e.g. console)
     */
    void communicate(Communicator communicator);

}
