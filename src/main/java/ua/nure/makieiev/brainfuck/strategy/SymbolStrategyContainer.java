package ua.nure.makieiev.brainfuck.strategy;

import ua.nure.makieiev.brainfuck.command.CommandContainer;
import ua.nure.makieiev.brainfuck.strategy.impl.DefaultSymbolStrategy;

import java.util.HashMap;
import java.util.Map;

public class SymbolStrategyContainer {

    private final Map<String, SymbolStrategy> symbolStrategies;
    private final CommandContainer commandContainer;

    public SymbolStrategyContainer(CommandContainer commandContainer) {
        this.commandContainer = commandContainer;
        symbolStrategies = new HashMap<>();
    }

    public void add(String symbol, SymbolStrategy symbolStrategy) {
        symbolStrategies.put(symbol, symbolStrategy);
    }

    public SymbolStrategy getSymbolStrategy(String symbol) {
        return symbolStrategies.getOrDefault(symbol, new DefaultSymbolStrategy(symbol, commandContainer));
    }

}
