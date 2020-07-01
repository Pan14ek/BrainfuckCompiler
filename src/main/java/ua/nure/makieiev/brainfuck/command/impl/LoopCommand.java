package ua.nure.makieiev.brainfuck.command.impl;

import ua.nure.makieiev.brainfuck.command.Command;
import ua.nure.makieiev.brainfuck.model.Memory;

import java.util.List;

public class LoopCommand implements Command {

    private List<Command> commands;

    public LoopCommand(List<Command> commands) {
        this.commands = commands;
    }

    @Override
    public void execute(Memory memory) {
        while (isNotEmptyCell(memory)) {
            commands.forEach(command -> command.execute(memory));
        }
    }

    private boolean isNotEmptyCell(Memory memory) {
        return memory.getMemory()[memory.getPosition()] != 0;
    }

}