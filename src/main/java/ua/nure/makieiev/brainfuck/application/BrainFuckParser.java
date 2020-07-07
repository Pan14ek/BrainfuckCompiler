package ua.nure.makieiev.brainfuck.application;

import ua.nure.makieiev.brainfuck.command.Command;
import ua.nure.makieiev.brainfuck.factory.SymbolFactory;
import ua.nure.makieiev.brainfuck.visitor.BrainFuckVisitor;

import java.util.Arrays;
import java.util.List;

import static ua.nure.makieiev.brainfuck.util.constant.BrainFuckConstant.EMPTY;

/**
 * The class is responsible for parsing string with special symbols to command list where each commands do some operation
 */
public class BrainFuckParser {

    private final SymbolFactory symbolFactory;
    private final BrainFuckVisitor brainFuckVisitor;

    public BrainFuckParser(SymbolFactory symbolFactory, BrainFuckVisitor brainFuckVisitor) {
        this.symbolFactory = symbolFactory;
        this.brainFuckVisitor = brainFuckVisitor;
    }

    /**
     * This method parses string with BrainFuck expressions to BrainFuck command list
     *
     * @param inputData is string with BrainFuck expressions
     * @return list of BrainFuck commands that came after the inputData parsing
     */
    public List<Command> parse(String inputData) {
        String[] symbols = inputData.split(EMPTY);
        Arrays.stream(symbols).forEach(symbol -> symbolFactory.getBrainFuckSymbol(symbol).accept(brainFuckVisitor));
        return brainFuckVisitor.getListOfCommands();
    }

}