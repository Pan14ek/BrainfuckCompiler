package ua.nure.makieiev.brainfuck.command.impl;

import ua.nure.makieiev.brainfuck.command.Command;
import ua.nure.makieiev.brainfuck.model.Memory;

import static ua.nure.makieiev.brainfuck.util.constant.BrainFuckConstant.ONE;

public class PreviousCellCommand implements Command {

    @Override
    public void execute(Memory memory) {
        memory.setPosition(memory.getPosition() - ONE);
    }

}
