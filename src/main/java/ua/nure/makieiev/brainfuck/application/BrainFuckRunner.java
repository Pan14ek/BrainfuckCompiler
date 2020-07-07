package ua.nure.makieiev.brainfuck.application;

import ua.nure.makieiev.brainfuck.factory.CommandFactory;
import ua.nure.makieiev.brainfuck.model.Memory;

/**
 * This class is responsible for starting BrainFuck application.
 */
public class BrainFuckRunner {

    /**
     * This method runs BrainFuck application
     *
     * @param inputData is string with BrainFuck expressions
     */
    public void run(String inputData) {
        Memory memory = new Memory();
        CommandFactory commandFactory = new CommandFactory();
        BrainFuckParser brainFuckParser = new BrainFuckParser(commandFactory);
        BrainFuckExecutor brainFuckExecutor = new BrainFuckExecutor(memory);
        brainFuckExecutor.execute(brainFuckParser.parse(inputData));
    }

}