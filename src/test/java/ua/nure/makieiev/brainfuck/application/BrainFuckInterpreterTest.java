package ua.nure.makieiev.brainfuck.application;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.nure.makieiev.brainfuck.application.context.ApplicationContext;
import ua.nure.makieiev.brainfuck.command.Command;

import java.util.List;

public class BrainFuckInterpreterTest {

    private BrainFuckInterpreter brainFuckInterpreter;

    @Before
    public void setUp() {
        ApplicationContext applicationContext = new ApplicationContext();
        brainFuckInterpreter = new BrainFuckInterpreter(applicationContext.getSymbolContainer(), applicationContext.getBrainFuckVisitor());
    }

    @Test
    public void shouldReturnTenCommands() {
        int expected = 10;

        List<Command> commands = brainFuckInterpreter.interpret("++++++++++");

        int actual = commands.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnElevenCommands() {
        int expected = 11;

        List<Command> commands = brainFuckInterpreter.interpret("++++++++++[>+++++++>++++++++++>+++>+<<<<-]");

        int actual = commands.size();

        Assert.assertEquals(expected, actual);
    }

}