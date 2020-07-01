package ua.nure.makieiev.brainfuck.strategy.impl;

import ua.nure.makieiev.brainfuck.command.Command;
import ua.nure.makieiev.brainfuck.command.CommandContainer;
import ua.nure.makieiev.brainfuck.strategy.SymbolStrategy;

import java.util.List;
import java.util.Stack;

public class DefaultSymbolStrategy implements SymbolStrategy {

    private final String symbol;
    private final CommandContainer commandContainer;

    public DefaultSymbolStrategy(String symbol, CommandContainer commandContainer) {
        this.symbol = symbol;
        this.commandContainer = commandContainer;
    }

    @Override
    public void execute(Stack<List<Command>> commandStack) {
        commandStack.peek().add(commandContainer.getCommand(symbol));
    }

}