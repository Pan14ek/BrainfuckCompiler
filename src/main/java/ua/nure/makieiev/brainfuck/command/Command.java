package ua.nure.makieiev.brainfuck.command;

import ua.nure.makieiev.brainfuck.model.Memory;

public interface Command {

    void execute(Memory memory);

}
