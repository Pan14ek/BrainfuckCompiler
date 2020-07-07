package ua.nure.makieiev.brainfuck.strategy.impl;

import ua.nure.makieiev.brainfuck.command.Command;
import ua.nure.makieiev.brainfuck.command.impl.LoopCommand;
import ua.nure.makieiev.brainfuck.strategy.SymbolStrategy;

import java.util.List;
import java.util.Stack;

/**
 * This class is responsible for creating loop command after popped the command list.
 */
public class EndLoopSymbolStrategy implements SymbolStrategy {

    /**
     * This method creates loop command and adds to first list(it is main list of commands).
     * Before list will be create , need to pop command list from stack(it is inner command list of loop)
     *
     * @param commandStack is stack with command list
     */
    @Override
    public void execute(Stack<List<Command>> commandStack) {
        List<Command> innerCommands = commandStack.pop();
        commandStack.peek().add(new LoopCommand(innerCommands));
    }

}