package ua.nure.makieiev.brainfuck.strategy;

import ua.nure.makieiev.brainfuck.command.Command;

import java.util.List;
import java.util.Stack;

/**
 * Main interface for the Strategy pattern implementation.
 */
public interface SymbolStrategy {

    /**
     * This method do some operations on input param.
     *
     * @param commandStack is stack with command list
     */
    void execute(Stack<List<Command>> commandStack);

}