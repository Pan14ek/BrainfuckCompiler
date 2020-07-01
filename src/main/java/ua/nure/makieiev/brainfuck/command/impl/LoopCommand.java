package ua.nure.makieiev.brainfuck.command.impl;

import ua.nure.makieiev.brainfuck.command.Command;
import ua.nure.makieiev.brainfuck.model.Memory;

import java.util.List;

import static ua.nure.makieiev.brainfuck.util.constant.BrainFuckConstant.ZERO;

public class LoopCommand implements Command {

    private final List<Command> commands;

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
        return memory.getMemory()[memory.getPosition()] != ZERO;
    }

}