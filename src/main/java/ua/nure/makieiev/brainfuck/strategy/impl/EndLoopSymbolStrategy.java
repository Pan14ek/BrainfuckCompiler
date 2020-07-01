package ua.nure.makieiev.brainfuck.strategy.impl;

import ua.nure.makieiev.brainfuck.command.Command;
import ua.nure.makieiev.brainfuck.command.impl.LoopCommand;
import ua.nure.makieiev.brainfuck.strategy.SymbolStrategy;

import java.util.List;
import java.util.Stack;

public class EndLoopSymbolStrategy implements SymbolStrategy {

    @Override
    public void execute(Stack<List<Command>> commandStack) {
        List<Command> innerCommands = commandStack.pop();
        commandStack.peek().add(new LoopCommand(innerCommands));
    }

}