package ua.nure.makieiev.brainfuck.application;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.nure.makieiev.brainfuck.command.Command;
import ua.nure.makieiev.brainfuck.factory.CommandFactory;
import ua.nure.makieiev.brainfuck.factory.SymbolStrategyFactory;

import java.util.List;

public class BrainFuckParserTest {

    private BrainFuckParser brainFuckParser;

    @Before
    public void setUp() {
        CommandFactory commandFactory = new CommandFactory();
        SymbolStrategyFactory symbolStrategyFactory = new SymbolStrategyFactory(commandFactory);
        brainFuckParser = new BrainFuckParser(symbolStrategyFactory);
    }

    @Test
    public void shouldReturnTenCommands() {
        int expected = 10;

        List<Command> commands = brainFuckParser.parse("++++++++++");

        int actual = commands.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnElevenCommands() {
        int expected = 11;

        List<Command> commands = brainFuckParser.parse("++++++++++[>+++++++>++++++++++>+++>+<<<<-]");

        int actual = commands.size();

        Assert.assertEquals(expected, actual);
    }

}