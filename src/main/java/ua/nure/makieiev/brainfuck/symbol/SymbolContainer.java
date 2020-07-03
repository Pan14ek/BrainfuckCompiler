package ua.nure.makieiev.brainfuck.symbol;

import ua.nure.makieiev.brainfuck.exception.NotFoundSymbolException;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class SymbolContainer {

    private final Map<String, BrainFuckSymbol> symbols;

    public SymbolContainer() {
        symbols = new HashMap<>();
    }

    public void add(String symbol, BrainFuckSymbol brainFuckSymbol) {
        symbols.put(symbol, brainFuckSymbol);
    }

    public BrainFuckSymbol getBrainFuckSymbol(String symbol) {
        return Optional.ofNullable(symbols.get(symbol))
                .orElseThrow(() -> new NotFoundSymbolException("Symbol did not find. Your symbol is " + symbol));
    }

}
