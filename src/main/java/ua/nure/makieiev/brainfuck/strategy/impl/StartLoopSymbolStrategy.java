package ua.nure.makieiev.brainfuck.strategy.impl;

import ua.nure.makieiev.brainfuck.command.Command;
import ua.nure.makieiev.brainfuck.strategy.SymbolStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StartLoopSymbolStrategy implements SymbolStrategy {

    @Override
    public void execute(Stack<List<Command>> commandStack) {
        commandStack.push(new ArrayList<>());
    }

}
