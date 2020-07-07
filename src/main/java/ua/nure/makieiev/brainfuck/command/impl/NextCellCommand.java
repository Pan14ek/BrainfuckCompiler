package ua.nure.makieiev.brainfuck.command.impl;

import ua.nure.makieiev.brainfuck.command.Command;
import ua.nure.makieiev.brainfuck.model.Memory;

import static ua.nure.makieiev.brainfuck.util.constant.BrainFuckConstant.ONE;
import static ua.nure.makieiev.brainfuck.util.constant.BrainFuckConstant.ZERO;

/**
 * The command is responsible for incrementing the data pointer (to point to the next cell to the right).
 */
public class NextCellCommand implements Command {

    /**
     * This method increments the data pointer
     *
     * @param memory is an object with an array on which certain actions are performed in specific commands
     */
    @Override
    public void execute(Memory memory) {
        if (isFullMemory(memory)) {
            memory.setPosition(ZERO);
        } else {
            memory.setPosition(memory.getPosition() + ONE);
        }
    }

    private boolean isFullMemory(Memory memory) {
        return memory.getPosition() == memory.getMemory().length - ONE;
    }

}