package ua.nure.makieiev.brainfuck.factory;

import ua.nure.makieiev.brainfuck.strategy.SymbolStrategy;
import ua.nure.makieiev.brainfuck.strategy.impl.EndLoopSymbolStrategy;
import ua.nure.makieiev.brainfuck.strategy.impl.StandardSymbolStrategy;
import ua.nure.makieiev.brainfuck.strategy.impl.StartLoopSymbolStrategy;

import java.util.HashMap;
import java.util.Map;

import static ua.nure.makieiev.brainfuck.util.constant.BrainFuckConstant.END_LOOP;
import static ua.nure.makieiev.brainfuck.util.constant.BrainFuckConstant.START_LOOP;

/**
 * This class is realized factory pattern.
 * This class is responsible for symbol strategy factory.
 */
public class SymbolStrategyFactory {

    private final Map<String, SymbolStrategy> symbolStrategies;
    private final CommandFactory commandFactory;

    public SymbolStrategyFactory(CommandFactory commandFactory) {
        this.commandFactory = commandFactory;
        symbolStrategies = new HashMap<>();
        addSymbolStrategies();
    }

    /**
     * This method gives special strategy for the received character.
     * If a specific operation such as loop brackets,then special strategies will be selected.
     * If the operations are standard(default), then the default strategy will be selected, which will call a special command.
     *
     * @param symbol is symbol after parsed string. This symbol needs for choosing special strategy.
     * @return a special symbol strategy after selection.
     */
    public SymbolStrategy getSymbolStrategy(String symbol) {
        return symbolStrategies.getOrDefault(symbol, new StandardSymbolStrategy(symbol, commandFactory));
    }

    private void addSymbolStrategies() {
        symbolStrategies.put(START_LOOP, new StartLoopSymbolStrategy());
        symbolStrategies.put(END_LOOP, new EndLoopSymbolStrategy());
    }

}