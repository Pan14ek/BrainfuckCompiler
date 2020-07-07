package ua.nure.makieiev.brainfuck.command.impl;

import ua.nure.makieiev.brainfuck.command.Command;
import ua.nure.makieiev.brainfuck.model.Memory;

import static ua.nure.makieiev.brainfuck.util.constant.BrainFuckConstant.ONE;
import static ua.nure.makieiev.brainfuck.util.constant.BrainFuckConstant.ZERO;

/**
 * The command is responsible for decrementing the data pointer (to point to the next cell to the left).
 */
public class PreviousCellCommand implements Command {

    /**
     * This method decrements the data pointer
     *
     * @param memory is an object with an array on which certain actions are performed in specific commands
     */
    @Override
    public void execute(Memory memory) {
        if (isEmptyCell(memory)) {
            memory.setPosition(memory.getMemory().length - ONE);
        } else {
            memory.setPosition(memory.getPosition() - ONE);
        }
    }

    private boolean isEmptyCell(Memory memory) {
        return memory.getPosition() == ZERO;
    }

}
