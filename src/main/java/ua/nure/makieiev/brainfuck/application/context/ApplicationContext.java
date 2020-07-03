package ua.nure.makieiev.brainfuck.application.context;

import ua.nure.makieiev.brainfuck.symbol.SymbolContainer;
import ua.nure.makieiev.brainfuck.symbol.impl.EndLoopSymbol;
import ua.nure.makieiev.brainfuck.symbol.impl.MinusSymbol;
import ua.nure.makieiev.brainfuck.symbol.impl.NextCellSymbol;
import ua.nure.makieiev.brainfuck.symbol.impl.PlusSymbol;
import ua.nure.makieiev.brainfuck.symbol.impl.PreviousCellSymbol;
import ua.nure.makieiev.brainfuck.symbol.impl.PrintSymbol;
import ua.nure.makieiev.brainfuck.symbol.impl.StartLoopSymbol;
import ua.nure.makieiev.brainfuck.visitor.BrainFuckVisitor;
import ua.nure.makieiev.brainfuck.visitor.impl.BrainFuckVisitorImpl;

import static ua.nure.makieiev.brainfuck.util.constant.BrainFuckConstant.END_LOOP;
import static ua.nure.makieiev.brainfuck.util.constant.BrainFuckConstant.MINUS_DATA_IN_CURRENT_CELL;
import static ua.nure.makieiev.brainfuck.util.constant.BrainFuckConstant.NEXT_CELL;
import static ua.nure.makieiev.brainfuck.util.constant.BrainFuckConstant.PLUS_DATA_IN_CURRENT_CELL;
import static ua.nure.makieiev.brainfuck.util.constant.BrainFuckConstant.PREVIOUS_CELL;
import static ua.nure.makieiev.brainfuck.util.constant.BrainFuckConstant.PRINT_INFORMATION;
import static ua.nure.makieiev.brainfuck.util.constant.BrainFuckConstant.START_LOOP;

public class ApplicationContext {

    private SymbolContainer symbolContainer;
    private BrainFuckVisitor brainFuckVisitor;

    public ApplicationContext() {
        init();
    }

    private void init() {
        symbolContainer = new SymbolContainer();
        brainFuckVisitor = new BrainFuckVisitorImpl();
        addSymbolContainer();
    }

    private void addSymbolContainer() {
        symbolContainer.add(NEXT_CELL, new NextCellSymbol());
        symbolContainer.add(PREVIOUS_CELL, new PreviousCellSymbol());
        symbolContainer.add(PLUS_DATA_IN_CURRENT_CELL, new PlusSymbol());
        symbolContainer.add(MINUS_DATA_IN_CURRENT_CELL, new MinusSymbol());
        symbolContainer.add(PRINT_INFORMATION, new PrintSymbol());
        symbolContainer.add(START_LOOP, new StartLoopSymbol());
        symbolContainer.add(END_LOOP, new EndLoopSymbol());
    }

    public SymbolContainer getSymbolContainer() {
        return symbolContainer;
    }

    public BrainFuckVisitor getBrainFuckVisitor() {
        return brainFuckVisitor;
    }

}