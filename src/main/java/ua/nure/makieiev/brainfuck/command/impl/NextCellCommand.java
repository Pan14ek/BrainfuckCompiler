package ua.nure.makieiev.brainfuck.command.impl;

import ua.nure.makieiev.brainfuck.command.Command;
import ua.nure.makieiev.brainfuck.model.Memory;

import static ua.nure.makieiev.brainfuck.util.constant.BrainFuckConstant.ONE;
import static ua.nure.makieiev.brainfuck.util.constant.BrainFuckConstant.ZERO;

public class NextCellCommand implements Command {

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