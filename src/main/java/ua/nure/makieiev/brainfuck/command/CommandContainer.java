package ua.nure.makieiev.brainfuck.command;

import ua.nure.makieiev.brainfuck.exception.NotFoundCommandException;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CommandContainer {

    private final Map<String, Command> commands;

    public CommandContainer() {
        commands = new HashMap<>();
    }

    public void add(String symbol, Command command) {
        commands.put(symbol, command);
    }

    public Command getCommand(String symbol) {
        return Optional.ofNullable(commands.get(symbol))
                .orElseThrow(() -> new NotFoundCommandException("Special command did not find by symbol. Your symbol is " + symbol));
    }

}