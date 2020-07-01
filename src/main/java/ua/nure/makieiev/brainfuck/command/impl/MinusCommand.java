package ua.nure.makieiev.brainfuck.command.impl;

import ua.nure.makieiev.brainfuck.command.Command;
import ua.nure.makieiev.brainfuck.model.Memory;

import static ua.nure.makieiev.brainfuck.util.constant.BrainFuckConstant.ZERO;

public class MinusCommand implements Command {

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