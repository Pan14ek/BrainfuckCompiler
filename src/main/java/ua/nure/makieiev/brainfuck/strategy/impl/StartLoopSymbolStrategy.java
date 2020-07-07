package ua.nure.makieiev.brainfuck.strategy.impl;

import ua.nure.makieiev.brainfuck.command.Command;
import ua.nure.makieiev.brainfuck.strategy.SymbolStrategy;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * This class is responsible for adding new list to stack if we have new loop.
 */
public class StartLoopSymbolStrategy implements SymbolStrategy {

    /**
     * This method adds new list to stack
     *
     * @param commandStack is stack with command list
     */
    @Override
    public void execute(Stack<List<Command>> commandStack) {
        commandStack.push(new LinkedList<>());
    }

}
