package ua.nure.makieiev.brainfuck.command.impl;

import ua.nure.makieiev.brainfuck.command.Command;
import ua.nure.makieiev.brainfuck.model.Memory;

public class PrintCommand implements Command {

    @Override
    public void execute(Memory memory) {
        System.out.println((char) memory.getMemory()[memory.getPosition()]);
    }

}