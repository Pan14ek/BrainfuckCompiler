package ua.nure.makieiev.brainfuck.strategy.impl;

import ua.nure.makieiev.brainfuck.command.Command;
import ua.nure.makieiev.brainfuck.factory.CommandFactory;
import ua.nure.makieiev.brainfuck.strategy.SymbolStrategy;

import java.util.List;
import java.util.Stack;

/**
 * This class is responsible for choosing standard commands.
 */
public class StandardSymbolStrategy implements SymbolStrategy {

    private final String symbol;
    private final CommandFactory commandFactory;

    public StandardSymbolStrategy(String symbol, CommandFactory commandFactory) {
        this.symbol = symbol;
        this.commandFactory = commandFactory;
    }

    /**
     * This method adds to list standard special command by symbol
     *
     * @param commandStack is stack with command list
     */
    @Override
    public void execute(Stack<List<Command>> commandStack) {
        commandStack.peek().add(commandFactory.getCommand(symbol));
    }

}