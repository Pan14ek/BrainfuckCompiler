package ua.nure.makieiev.brainfuck.application;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.nure.makieiev.brainfuck.application.context.ApplicationContext;
import ua.nure.makieiev.brainfuck.command.Command;

import java.util.List;

public class BrainFuckTest {

    private BrainFuck brainFuck;

    @Before
    public void setUp() {
        ApplicationContext applicationContext = new ApplicationContext();
        brainFuck = new BrainFuck(applicationContext.getSymbolStrategyContainer());
    }

    @Test
    public void shouldReturnTenCommands() {
        int expected = 10;

        List<Command> commands = brainFuck.interpret("++++++++++");

        int actual = commands.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnElevenCommands() {
        int expected = 11;

        List<Command> commands = brainFuck.interpret("++++++++++[>+++++++>++++++++++>+++>+<<<<-]");

        int actual = commands.size();

        Assert.assertEquals(expected, actual);
    }

}