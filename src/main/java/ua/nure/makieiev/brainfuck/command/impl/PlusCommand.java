package ua.nure.makieiev.brainfuck.command.impl;

import ua.nure.makieiev.brainfuck.command.Command;
import ua.nure.makieiev.brainfuck.model.Memory;

/**
 * The command is responsible for incrementing (increase by one) the byte at the data pointer.
 */
public class PlusCommand implements Command {

    /**
     * This method increments the byte at the data pointer
     *
     * @param memory is an object with an array on which certain actions are performed in specific commands
     */
    @Override
    public void execute(Memory memory) {
        memory.getMemory()[memory.getPosition()]++;
    }

}