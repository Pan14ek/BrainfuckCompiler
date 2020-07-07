package ua.nure.makieiev.brainfuck.command.impl;

import ua.nure.makieiev.brainfuck.command.Command;
import ua.nure.makieiev.brainfuck.model.Memory;

import java.util.List;

import static ua.nure.makieiev.brainfuck.util.constant.BrainFuckConstant.ZERO;

/**
 * The command is responsible for loop operation.
 * The command uses inner commands for to cycle through cells
 */
public class LoopCommand implements Command {

    private final List<Command> innerCommands;

    public LoopCommand(List<Command> innerCommands) {
        this.innerCommands = innerCommands;
    }

    /**
     * This method goes through the inner commands and performs certain actions on the memory.
     * But before execution, the cell is checked for emptiness.
     *
     * @param memory is an object with an array on which certain actions are performed in specific commands
     */
    @Override
    public void execute(Memory memory) {
        while (isNotEmptyCell(memory)) {
            innerCommands.forEach(command -> command.execute(memory));
        }
    }

    private boolean isNotEmptyCell(Memory memory) {
        return memory.getMemory()[memory.getPosition()] != ZERO;
    }

}