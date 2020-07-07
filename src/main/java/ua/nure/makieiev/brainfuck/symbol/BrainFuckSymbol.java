package ua.nure.makieiev.brainfuck.symbol;

import ua.nure.makieiev.brainfuck.visitor.BrainFuckVisitor;

/**
 * This class is responsible for visiting special symbols
 */
public interface BrainFuckSymbol {

    /**
     * This method call specific visitor. The specific visitor depends on the character being called.
     *
     * @param brainFuckVisitor is BrainFuck visitor that calls a specific visitor
     */
    void accept(BrainFuckVisitor brainFuckVisitor);

}