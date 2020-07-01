package ua.nure.makieiev.brainfuck.command.impl;

import ua.nure.makieiev.brainfuck.command.Command;
import ua.nure.makieiev.brainfuck.model.Memory;

import static ua.nure.makieiev.brainfuck.util.constant.BrainFuckConstant.ONE;
import static ua.nure.makieiev.brainfuck.util.constant.BrainFuckConstant.ZERO;

public class PreviousCellCommand implements Command {

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
