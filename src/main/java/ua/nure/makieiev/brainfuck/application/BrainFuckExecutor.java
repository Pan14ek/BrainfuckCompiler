package ua.nure.makieiev.brainfuck.application;

import ua.nure.makieiev.brainfuck.command.Command;
import ua.nure.makieiev.brainfuck.model.Memory;

import java.util.List;

/**
 * The class is responsible for executing BrainFuck commands
 */
public class BrainFuckExecutor {

    private final Memory memory;

    public BrainFuckExecutor(Memory memory) {
        this.memory = memory;
    }

    /**
     * This method execute commands after BrainFuck expressions parsing.
     *
     * @param commands are special commands after parse the string with expressions
     */
    public void execute(List<Command> commands) {
        commands.forEach(command -> command.execute(memory));
    }

}