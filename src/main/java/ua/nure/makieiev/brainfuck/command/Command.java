package ua.nure.makieiev.brainfuck.command;

import ua.nure.makieiev.brainfuck.model.Memory;

/**
 * Main interface for the Command pattern implementation.
 */
public interface Command {

    /**
     * This method should do BrainFuck operations
     *
     * @param memory is an object with an array on which certain actions are performed in specific commands
     */
    void execute(Memory memory);

}
