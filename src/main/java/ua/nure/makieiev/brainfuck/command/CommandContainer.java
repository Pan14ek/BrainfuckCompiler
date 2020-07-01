package ua.nure.makieiev.brainfuck.command;

import java.util.HashMap;
import java.util.Map;

public class CommandContainer {

    private final Map<String, Command> commandMap;

    public CommandContainer() {
        commandMap = new HashMap<>();
    }

    public void add(String key, Command command) {
        commandMap.put(key, command);
    }

    public Command getCommand(String key) {
        return commandMap.get(key);
    }

}