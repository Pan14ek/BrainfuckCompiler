package ua.nure.makieiev.brainfuck.application;

import ua.nure.makieiev.brainfuck.command.Command;
import ua.nure.makieiev.brainfuck.factory.SymbolStrategyFactory;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import static ua.nure.makieiev.brainfuck.util.constant.BrainFuckConstant.EMPTY;

/**
 * The class is responsible for parsing string with special symbols to command list where each commands do some operation
 */
public class BrainFuckParser {

    private final SymbolStrategyFactory symbolStrategyFactory;

    public BrainFuckParser(SymbolStrategyFactory symbolStrategyFactory) {
        this.symbolStrategyFactory = symbolStrategyFactory;
    }

    /**
     * This method parses string with BrainFuck expressions to BrainFuck command list
     *
     * @param inputData is string with BrainFuck expressions
     * @return list of BrainFuck commands that came after the inputData parsing
     */
    public List<Command> parse(String inputData) {
        Stack<List<Command>> commandStack = new Stack<>();
        commandStack.push(new LinkedList<>());
        String[] symbols = inputData.split(EMPTY);
        Arrays.stream(symbols).forEach(symbol -> symbolStrategyFactory.getSymbolStrategy(symbol).execute(commandStack));
        return commandStack.peek();
    }

}