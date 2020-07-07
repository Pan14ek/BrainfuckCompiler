package ua.nure.makieiev.brainfuck.application;

import ua.nure.makieiev.brainfuck.command.Command;
import ua.nure.makieiev.brainfuck.command.impl.LoopCommand;
import ua.nure.makieiev.brainfuck.factory.CommandFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

import static ua.nure.makieiev.brainfuck.util.constant.BrainFuckConstant.EMPTY;
import static ua.nure.makieiev.brainfuck.util.constant.BrainFuckConstant.END_LOOP;
import static ua.nure.makieiev.brainfuck.util.constant.BrainFuckConstant.START_LOOP;

/**
 * The class is responsible for parsing string with special symbols to command list where each commands do some operation
 */
public class BrainFuckParser {

    private final Stack<List<Command>> commandStack;
    private final CommandFactory commandFactory;

    public BrainFuckParser(CommandFactory commandFactory) {
        this.commandFactory = commandFactory;
        commandStack = new Stack<>();
        commandStack.push(new LinkedList<>());
    }

    /**
     * This method parses string with BrainFuck expressions to BrainFuck command list
     *
     * @param inputData is string with BrainFuck expressions
     * @return list of BrainFuck commands that came after the inputData parsing
     */
    public List<Command> parse(String inputData) {
        String[] symbols = inputData.split(EMPTY);
        for (String symbol : symbols) {
            checkSymbol(symbol);
        }
        return commandStack.peek();
    }

    private void checkSymbol(String symbol) {
        if (Objects.equals(symbol, START_LOOP)) {
            commandStack.push(new LinkedList<>());
        } else if (Objects.equals(symbol, END_LOOP)) {
            List<Command> innerCommands = commandStack.pop();
            commandStack.peek().add(new LoopCommand(innerCommands));
        } else {
            commandStack.peek().add(commandFactory.getCommand(symbol));
        }
    }

}