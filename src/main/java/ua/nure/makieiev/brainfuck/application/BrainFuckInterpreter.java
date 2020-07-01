package ua.nure.makieiev.brainfuck.application;

import ua.nure.makieiev.brainfuck.command.Command;
import ua.nure.makieiev.brainfuck.strategy.SymbolStrategyContainer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import static ua.nure.makieiev.brainfuck.util.constant.BrainFuckConstant.EMPTY;

public class BrainFuckInterpreter {

    private final SymbolStrategyContainer symbolStrategyContainer;

    public BrainFuckInterpreter(SymbolStrategyContainer symbolStrategyContainer) {
        this.symbolStrategyContainer = symbolStrategyContainer;
    }

    public List<Command> interpret(String inputData) {
        Stack<List<Command>> commandStack = new Stack<>();
        commandStack.push(new ArrayList<>());
        String[] symbols = inputData.split(EMPTY);
        Arrays.stream(symbols).forEach(symbol -> symbolStrategyContainer.getSymbolStrategy(symbol).execute(commandStack));
        return commandStack.peek();
    }

}