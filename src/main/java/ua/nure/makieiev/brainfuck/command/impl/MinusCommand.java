package ua.nure.makieiev.brainfuck.command.impl;

import ua.nure.makieiev.brainfuck.command.Command;
import ua.nure.makieiev.brainfuck.model.Memory;

import static ua.nure.makieiev.brainfuck.util.constant.BrainFuckConstant.ZERO;

/**
 * The command is responsible for decrementing (decrease by one) the byte at the data pointer.
 */
public class MinusCommand implements Command {

    /**
     * This method decrements the byte at the data pointer
     *
     * @param memory is an object with an array on which certain actions are performed in specific commands
     */
    @Override
    public void execute(Memory memory) {
        if (isPositiveCell(memory)) {
            memory.getMemory()[memory.getPosition()]--;
        }
    }

    private boolean isPositiveCell(Memory memory) {
        return memory.getMemory()[memory.getPosition()] > ZERO;
    }

}