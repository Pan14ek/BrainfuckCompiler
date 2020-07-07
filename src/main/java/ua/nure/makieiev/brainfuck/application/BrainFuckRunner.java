package ua.nure.makieiev.brainfuck.application;

import ua.nure.makieiev.brainfuck.factory.SymbolFactory;
import ua.nure.makieiev.brainfuck.model.Memory;
import ua.nure.makieiev.brainfuck.visitor.BrainFuckVisitor;
import ua.nure.makieiev.brainfuck.visitor.impl.BrainFuckVisitorImpl;

/**
 * This class is responsible for starting BrainFuck compiler.
 */
public class BrainFuckRunner {

    /**
     * This method runs BrainFuck application
     *
     * @param inputData is string with BrainFuck expressions
     */
    public void run(String inputData) {
        Memory memory = new Memory();
        BrainFuckVisitor brainFuckVisitor = new BrainFuckVisitorImpl();
        SymbolFactory symbolFactory = new SymbolFactory();
        BrainFuckParser brainFuckParser = new BrainFuckParser(symbolFactory, brainFuckVisitor);
        BrainFuckExecutor brainFuckExecutor = new BrainFuckExecutor(memory);
        brainFuckExecutor.execute(brainFuckParser.parse(inputData));
    }

}