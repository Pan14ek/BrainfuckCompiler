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

/**
 * The BrainFuckVisitor interface declares a set of visiting methods that correspond to BrainFuck symbols.
 */
public interface BrainFuckVisitor {

    /**
     * This method visits plusSymbol for adding PlusCommand
     *
     * @param plusSymbol is plus symbol which is responsible for adding PlusCommand
     */
    void visit(PlusSymbol plusSymbol);

    /**
     * This method visits minusSymbol for adding MinusCommand
     *
     * @param minusSymbol is minus symbol which is responsible for adding MinusCommand
     */
    void visit(MinusSymbol minusSymbol);

    /**
     * This method visits previousCellSymbol for adding PreviousCellCommand
     *
     * @param previousCellSymbol is previous cell symbol which is responsible for adding PreviousCellCommand
     */
    void visit(PreviousCellSymbol previousCellSymbol);

    /**
     * This method visits nextCellSymbol for adding NextCellCommand
     *
     * @param nextCellSymbol is next cell symbol which is responsible for adding NextCellCommand
     */
    void visit(NextCellSymbol nextCellSymbol);

    /**
     * This method visits startLoopSymbol for adding new list to stack
     *
     * @param startLoopSymbol is start loop symbol which is responsible for adding new list to stack
     */
    void visit(StartLoopSymbol startLoopSymbol);

    /**
     * This method visits endLoopSymbol for adding popped inner command list to main list with commands
     *
     * @param endLoopSymbol is end loop symbol which is responsible for creating LoopCommand and adding in this
     *                      command popped inner command list
     */
    void visit(EndLoopSymbol endLoopSymbol);

    /**
     * This method visits printSymbol for adding PrintCommand
     *
     * @param printSymbol is print symbol which is responsible for adding PrintCommand
     */
    void visit(PrintSymbol printSymbol);

    /**
     * This method returns list of BrainFuck commands
     *
     * @return list of BrainFuck commands
     */
    List<Command> getListOfCommands();

}