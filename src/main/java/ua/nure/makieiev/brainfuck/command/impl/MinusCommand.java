package ua.nure.makieiev.brainfuck.command.impl;

import ua.nure.makieiev.brainfuck.command.Command;
import ua.nure.makieiev.brainfuck.model.Memory;

public class MinusCommand implements Command {

    @Override
    public void execute(Memory memory) {
        memory.getMemory()[memory.getPosition()]--;
    }

}