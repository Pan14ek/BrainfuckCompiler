package ua.nure.makieiev.brainfuck.factory;

import ua.nure.makieiev.brainfuck.exception.NotFoundSymbolException;
import ua.nure.makieiev.brainfuck.symbol.BrainFuckSymbol;
import ua.nure.makieiev.brainfuck.symbol.impl.EndLoopSymbol;
import ua.nure.makieiev.brainfuck.symbol.impl.MinusSymbol;
import ua.nure.makieiev.brainfuck.symbol.impl.NextCellSymbol;
import ua.nure.makieiev.brainfuck.symbol.impl.PlusSymbol;
import ua.nure.makieiev.brainfuck.symbol.impl.PreviousCellSymbol;
import ua.nure.makieiev.brainfuck.symbol.impl.PrintSymbol;
import ua.nure.makieiev.brainfuck.symbol.impl.StartLoopSymbol;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static ua.nure.makieiev.brainfuck.util.constant.BrainFuckConstant.END_LOOP;
import static ua.nure.makieiev.brainfuck.util.constant.BrainFuckConstant.MINUS_DATA_IN_CURRENT_CELL;
import static ua.nure.makieiev.brainfuck.util.constant.BrainFuckConstant.NEXT_CELL;
import static ua.nure.makieiev.brainfuck.util.constant.BrainFuckConstant.PLUS_DATA_IN_CURRENT_CELL;
import static ua.nure.makieiev.brainfuck.util.constant.BrainFuckConstant.PREVIOUS_CELL;
import static ua.nure.makieiev.brainfuck.util.constant.BrainFuckConstant.PRINT_INFORMATION;
import static ua.nure.makieiev.brainfuck.util.constant.BrainFuckConstant.START_LOOP;

/**
 * This class is realized factory pattern.
 * This class is responsible for symbol factory.
 */
public class SymbolFactory {

    private final Map<String, BrainFuckSymbol> symbols;

    public SymbolFactory() {
        symbols = new HashMap<>();
        addSymbolContainer();
    }

    /**
     * This method gives a BrainFuck symbol for the received character.
     * If there is no desired character then throws an exception NotFoundSymbolException.
     *
     * @param symbol is symbol after parsed string. This symbol needs for choosing special brain fuck symbol.
     * @return a special BrainFuck symbol after selection.
     */
    public BrainFuckSymbol getBrainFuckSymbol(String symbol) {
        return Optional.ofNullable(symbols.get(symbol))
                .orElseThrow(() -> new NotFoundSymbolException("Symbol did not find. Your symbol is " + symbol));
    }

    private void addSymbolContainer() {
        symbols.put(NEXT_CELL, new NextCellSymbol());
        symbols.put(PREVIOUS_CELL, new PreviousCellSymbol());
        symbols.put(PLUS_DATA_IN_CURRENT_CELL, new PlusSymbol());
        symbols.put(MINUS_DATA_IN_CURRENT_CELL, new MinusSymbol());
        symbols.put(PRINT_INFORMATION, new PrintSymbol());
        symbols.put(START_LOOP, new StartLoopSymbol());
        symbols.put(END_LOOP, new EndLoopSymbol());
    }

}