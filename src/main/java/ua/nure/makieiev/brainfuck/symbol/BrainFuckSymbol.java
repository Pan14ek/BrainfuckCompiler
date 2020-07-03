package ua.nure.makieiev.brainfuck.symbol;

import ua.nure.makieiev.brainfuck.visitor.BrainFuckVisitor;

public interface BrainFuckSymbol {

    void accept(BrainFuckVisitor brainFuckVisitor);

}
