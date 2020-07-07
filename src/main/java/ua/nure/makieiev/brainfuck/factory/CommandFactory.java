package ua.nure.makieiev.brainfuck.factory;

import ua.nure.makieiev.brainfuck.command.Command;
import ua.nure.makieiev.brainfuck.command.impl.MinusCommand;
import ua.nure.makieiev.brainfuck.command.impl.NextCellCommand;
import ua.nure.makieiev.brainfuck.command.impl.PlusCommand;
import ua.nure.makieiev.brainfuck.command.impl.PreviousCellCommand;
import ua.nure.makieiev.brainfuck.command.impl.PrintCommand;
import ua.nure.makieiev.brainfuck.exception.NotFoundCommandException;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static ua.nure.makieiev.brainfuck.util.constant.BrainFuckConstant.MINUS_DATA_IN_CURRENT_CELL;
import static ua.nure.makieiev.brainfuck.util.constant.BrainFuckConstant.NEXT_CELL;
import static ua.nure.makieiev.brainfuck.util.constant.BrainFuckConstant.PLUS_DATA_IN_CURRENT_CELL;
import static ua.nure.makieiev.brainfuck.util.constant.BrainFuckConstant.PREVIOUS_CELL;
import static ua.nure.makieiev.brainfuck.util.constant.BrainFuckConstant.PRINT_INFORMATION;

/**
 * This class is realized factory pattern.
 * This class is responsible for command factory.
 */
public class CommandFactory {

    private final Map<String, Command> commands;

    public CommandFactory() {
        commands = new HashMap<>();
        addCommands();
    }

    /**
     * This method gives a command for the received character.
     * If there is no desired character then throws an exception NotFoundCommandException.
     *
     * @param symbol is symbol after parsed string. This symbol needs for choosing special command.
     * @return a special command after selection.
     */
    public Command getCommand(String symbol) {
        return Optional.ofNullable(commands.get(symbol))
                .orElseThrow(() -> new NotFoundCommandException("Special command did not find by symbol. Your symbol is " + symbol));
    }

    private void addCommands() {
        commands.put(NEXT_CELL, new NextCellCommand());
        commands.put(PREVIOUS_CELL, new PreviousCellCommand());
        commands.put(PLUS_DATA_IN_CURRENT_CELL, new PlusCommand());
        commands.put(MINUS_DATA_IN_CURRENT_CELL, new MinusCommand());
        commands.put(PRINT_INFORMATION, new PrintCommand());
    }

}