package ua.nure.makieiev.brainfuck.application;

import ua.nure.makieiev.brainfuck.application.context.ApplicationContext;
import ua.nure.makieiev.brainfuck.command.Command;
import ua.nure.makieiev.brainfuck.model.Memory;
import ua.nure.makieiev.brainfuck.symbol.SymbolContainer;
import ua.nure.makieiev.brainfuck.visitor.BrainFuckVisitor;

import java.util.List;

public class BrainFuckRunner {

    private final ApplicationContext applicationContext;

    public BrainFuckRunner() {
        applicationContext = new ApplicationContext();
    }

    public void run(String inputData) {
        Memory memory = new Memory();
        BrainFuckVisitor brainFuckVisitor = applicationContext.getBrainFuckVisitor();
        SymbolContainer symbolContainer = applicationContext.getSymbolContainer();
        BrainFuckInterpreter brainFuckInterpreter = new BrainFuckInterpreter(symbolContainer, brainFuckVisitor);
        List<Command> commands = brainFuckInterpreter.interpret(inputData);
        commands.forEach(command -> command.execute(memory));
    }

}