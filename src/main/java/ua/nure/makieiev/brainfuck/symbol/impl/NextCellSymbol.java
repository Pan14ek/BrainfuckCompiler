package ua.nure.makieiev.brainfuck.symbol.impl;

import ua.nure.makieiev.brainfuck.symbol.BrainFuckSymbol;
import ua.nure.makieiev.brainfuck.visitor.BrainFuckVisitor;

public class NextCellSymbol implements BrainFuckSymbol {

    @Override
    public void accept(BrainFuckVisitor brainFuckVisitor) {
        brainFuckVisitor.visit(this);
    }

}