package ua.nure.makieiev.brainfuck.application.context;

import ua.nure.makieiev.brainfuck.command.CommandContainer;
import ua.nure.makieiev.brainfuck.command.impl.MinusCommand;
import ua.nure.makieiev.brainfuck.command.impl.NextCellCommand;
import ua.nure.makieiev.brainfuck.command.impl.PlusCommand;
import ua.nure.makieiev.brainfuck.command.impl.PreviousCellCommand;
import ua.nure.makieiev.brainfuck.command.impl.PrintCommand;
import ua.nure.makieiev.brainfuck.strategy.SymbolStrategyContainer;
import ua.nure.makieiev.brainfuck.strategy.impl.EndLoopSymbolStrategy;
import ua.nure.makieiev.brainfuck.strategy.impl.StartLoopSymbolStrategy;

import static ua.nure.makieiev.brainfuck.util.constant.BrainFuckConstant.END_LOOP;
import static ua.nure.makieiev.brainfuck.util.constant.BrainFuckConstant.MINUS_DATA_IN_CURRENT_CELL;
import static ua.nure.makieiev.brainfuck.util.constant.BrainFuckConstant.NEXT_CELL;
import static ua.nure.makieiev.brainfuck.util.constant.BrainFuckConstant.PLUS_DATA_IN_CURRENT_CELL;
import static ua.nure.makieiev.brainfuck.util.constant.BrainFuckConstant.PREVIOUS_CELL;
import static ua.nure.makieiev.brainfuck.util.constant.BrainFuckConstant.PRINT_INFORMATION;
import static ua.nure.makieiev.brainfuck.util.constant.BrainFuckConstant.START_LOOP;

public class ApplicationContext {

    private CommandContainer commandContainer;
    private SymbolStrategyContainer symbolStrategyContainer;

    public ApplicationContext() {
        init();
    }

    private void init() {
        commandContainer = new CommandContainer();
        symbolStrategyContainer = new SymbolStrategyContainer(commandContainer);
        addCommands();
        addSymbolStrategies();
    }

    private void addCommands() {
        commandContainer.add(NEXT_CELL, new NextCellCommand());
        commandContainer.add(PREVIOUS_CELL, new PreviousCellCommand());
        commandContainer.add(PLUS_DATA_IN_CURRENT_CELL, new PlusCommand());
        commandContainer.add(MINUS_DATA_IN_CURRENT_CELL, new MinusCommand());
        commandContainer.add(PRINT_INFORMATION, new PrintCommand());
    }

    private void addSymbolStrategies() {
        symbolStrategyContainer.add(START_LOOP, new StartLoopSymbolStrategy());
        symbolStrategyContainer.add(END_LOOP, new EndLoopSymbolStrategy());
    }

    public SymbolStrategyContainer getSymbolStrategyContainer() {
        return symbolStrategyContainer;
    }

}