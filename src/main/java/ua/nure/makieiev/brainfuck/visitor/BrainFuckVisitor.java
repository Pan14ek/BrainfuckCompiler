package ua.nure.makieiev.brainfuck.visitor;

import ua.nure.makieiev.brainfuck.command.Command;
import ua.nure.makieiev.brainfuck.symbol.impl.EndLoopSymbol;
import ua.nure.makieiev.brainfuck.symbol.impl.MinusSymbol;
import ua.nure.makieiev.brainfuck.symbol.impl.NextCellSymbol;
import ua.nure.makieiev.brainfuck.symbol.impl.PlusSymbol;
import ua.nure.makieiev.brainfuck.symbol.impl.PreviousCellSymbol;
import ua.nure.makieiev.brainfuck.symbol.impl.PrintSymbol;
import ua.nure.makieiev.brainfuck.symbol.impl.StartLoopSymbol;

import java.util.List;

public interface BrainFuckVisitor {

    void visit(PlusSymbol plusSymbol);

    void visit(MinusSymbol minusSymbol);

    void visit(PreviousCellSymbol previousCellSymbol);

    void visit(NextCellSymbol nextCellSymbol);

    void visit(StartLoopSymbol startLoopSymbol);

    void visit(EndLoopSymbol endLoopSymbol);

    void visit(PrintSymbol printSymbol);

    List<Command> getCommands();

}