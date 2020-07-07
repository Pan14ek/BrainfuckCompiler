package ua.nure.makieiev.brainfuck.application;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.nure.makieiev.brainfuck.command.Command;
import ua.nure.makieiev.brainfuck.factory.SymbolFactory;
import ua.nure.makieiev.brainfuck.visitor.BrainFuckVisitor;
import ua.nure.makieiev.brainfuck.visitor.impl.BrainFuckVisitorImpl;

import java.util.List;

public class BrainFuckParserTest {

    private BrainFuckParser brainFuckParser;

    @Before
    public void setUp() {
        BrainFuckVisitor brainFuckVisitor = new BrainFuckVisitorImpl();
        SymbolFactory symbolFactory = new SymbolFactory();
        brainFuckParser = new BrainFuckParser(symbolFactory, brainFuckVisitor);
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