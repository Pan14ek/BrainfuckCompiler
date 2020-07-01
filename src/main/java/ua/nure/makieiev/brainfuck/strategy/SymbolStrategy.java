package ua.nure.makieiev.brainfuck.strategy;

import ua.nure.makieiev.brainfuck.command.Command;

import java.util.List;
import java.util.Stack;

public interface SymbolStrategy {

    void execute(Stack<List<Command>> commandStack);

}