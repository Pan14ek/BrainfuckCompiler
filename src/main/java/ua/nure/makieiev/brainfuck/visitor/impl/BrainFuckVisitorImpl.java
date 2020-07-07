package ua.nure.makieiev.brainfuck.visitor.impl;

import ua.nure.makieiev.brainfuck.command.Command;
import ua.nure.makieiev.brainfuck.command.impl.LoopCommand;
import ua.nure.makieiev.brainfuck.command.impl.MinusCommand;
import ua.nure.makieiev.brainfuck.command.impl.NextCellCommand;
import ua.nure.makieiev.brainfuck.command.impl.PlusCommand;
import ua.nure.makieiev.brainfuck.command.impl.PreviousCellCommand;
import ua.nure.makieiev.brainfuck.command.impl.PrintCommand;
import ua.nure.makieiev.brainfuck.symbol.impl.EndLoopSymbol;
import ua.nure.makieiev.brainfuck.symbol.impl.MinusSymbol;
import ua.nure.makieiev.brainfuck.symbol.impl.NextCellSymbol;
import ua.nure.makieiev.brainfuck.symbol.impl.PlusSymbol;
import ua.nure.makieiev.brainfuck.symbol.impl.PreviousCellSymbol;
import ua.nure.makieiev.brainfuck.symbol.impl.PrintSymbol;
import ua.nure.makieiev.brainfuck.symbol.impl.StartLoopSymbol;
import ua.nure.makieiev.brainfuck.visitor.BrainFuckVisitor;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Implementation of BrainFUckVisitor
 */
public class BrainFuckVisitorImpl implements BrainFuckVisitor {

    private final Stack<List<Command>> commands;

    public BrainFuckVisitorImpl() {
        commands = new Stack<>();
        addNewList();
    }

    /**
     * This method visits plusSymbol for adding PlusCommand
     *
     * @param plusSymbol is plus symbol which is responsible for adding PlusCommand
     */
    @Override
    public void visit(PlusSymbol plusSymbol) {
        commands.peek().add(new PlusCommand());
    }

    /**
     * This method visits minusSymbol for adding MinusCommand
     *
     * @param minusSymbol is minus symbol which is responsible for adding MinusCommand
     */
    @Override
    public void visit(MinusSymbol minusSymbol) {
        commands.peek().add(new MinusCommand());
    }

    /**
     * This method visits previousCellSymbol for adding PreviousCellCommand
     *
     * @param previousCellSymbol is previous cell symbol which is responsible for adding PreviousCellCommand
     */
    @Override
    public void visit(PreviousCellSymbol previousCellSymbol) {
        commands.peek().add(new PreviousCellCommand());
    }

    /**
     * This method visits nextCellSymbol for adding NextCellCommand
     *
     * @param nextCellSymbol is next cell symbol which is responsible for adding NextCellCommand
     */
    @Override
    public void visit(NextCellSymbol nextCellSymbol) {
        commands.peek().add(new NextCellCommand());
    }

    /**
     * This method visits startLoopSymbol for adding new list to stack
     *
     * @param startLoopSymbol is start loop symbol which is responsible for adding new list to stack
     */
    @Override
    public void visit(StartLoopSymbol startLoopSymbol) {
        addNewList();
    }

    /**
     * This method visits endLoopSymbol for adding popped inner command list to main list with commands
     *
     * @param endLoopSymbol is end loop symbol which is responsible for creating LoopCommand and adding in this
     *                      command popped inner command list
     */
    @Override
    public void visit(EndLoopSymbol endLoopSymbol) {
        List<Command> innerCommands = commands.pop();
        commands.peek().add(new LoopCommand(innerCommands));
    }

    /**
     * This method visits printSymbol for adding PrintCommand
     *
     * @param printSymbol is print symbol which is responsible for adding PrintCommand
     */
    @Override
    public void visit(PrintSymbol printSymbol) {
        commands.peek().add(new PrintCommand());
    }

    /**
     * This method returns list of BrainFuck commands
     *
     * @return list of BrainFuck commands
     */
    @Override
    public List<Command> getListOfCommands() {
        return commands.pop();
    }

    private void addNewList() {
        commands.push(new LinkedList<>());
    }

}
