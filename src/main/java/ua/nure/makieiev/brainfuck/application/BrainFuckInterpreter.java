package ua.nure.makieiev.brainfuck.application;

import ua.nure.makieiev.brainfuck.command.Command;
import ua.nure.makieiev.brainfuck.symbol.SymbolContainer;
import ua.nure.makieiev.brainfuck.visitor.BrainFuckVisitor;

import java.util.Arrays;
import java.util.List;

import static ua.nure.makieiev.brainfuck.util.constant.BrainFuckConstant.EMPTY;

public class BrainFuckInterpreter {

    private final SymbolContainer symbolContainer;
    private final BrainFuckVisitor brainFuckVisitor;

    public BrainFuckInterpreter(SymbolContainer symbolContainer, BrainFuckVisitor brainFuckVisitor) {
        this.symbolContainer = symbolContainer;
        this.brainFuckVisitor = brainFuckVisitor;
    }

    public List<Command> interpret(String inputData) {
        String[] symbols = inputData.split(EMPTY);
        Arrays.stream(symbols).forEach(symbol -> symbolContainer.getBrainFuckSymbol(symbol).accept(brainFuckVisitor));
        return brainFuckVisitor.getCommands();
    }

}