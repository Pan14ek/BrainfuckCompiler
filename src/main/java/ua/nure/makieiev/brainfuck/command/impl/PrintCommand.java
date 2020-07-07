package ua.nure.makieiev.brainfuck.command.impl;

import ua.nure.makieiev.brainfuck.command.Command;
import ua.nure.makieiev.brainfuck.model.Memory;

/**
 * The command is responsible for outputting the byte at the data pointer.
 */
public class PrintCommand implements Command {

    /**
     * This method outputs(print information) the byte at the data pointer.
     *
     * @param memory is an object with an array on which certain actions are performed in specific commands
     */
    @Override
    public void execute(Memory memory) {
        System.out.print((char) memory.getMemory()[memory.getPosition()]);
    }

}