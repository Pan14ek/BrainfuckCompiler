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

public class BrainFuckVisitorImpl implements BrainFuckVisitor {

    private final Stack<List<Command>> commands;

    public BrainFuckVisitorImpl() {
        commands = new Stack<>();
        addNewList();
    }

    @Override
    public void visit(PlusSymbol plusSymbol) {
        commands.peek().add(new PlusCommand());
    }

    @Override
    public void visit(MinusSymbol minusSymbol) {
        commands.peek().add(new MinusCommand());
    }

    @Override
    public void visit(PreviousCellSymbol previousCellSymbol) {
        commands.peek().add(new PreviousCellCommand());
    }

    @Override
    public void visit(NextCellSymbol nextCellSymbol) {
        commands.peek().add(new NextCellCommand());
    }

    @Override
    public void visit(StartLoopSymbol startLoopSymbol) {
        addNewList();
    }

    @Override
    public void visit(EndLoopSymbol endLoopSymbol) {
        List<Command> innerCommands = commands.pop();
        commands.peek().add(new LoopCommand(innerCommands));
    }

    @Override
    public void visit(PrintSymbol printSymbol) {
        commands.peek().add(new PrintCommand());
    }

    @Override
    public List<Command> getCommands() {
        return commands.pop();
    }

    private void addNewList() {
        commands.push(new LinkedList<>());
    }

}
