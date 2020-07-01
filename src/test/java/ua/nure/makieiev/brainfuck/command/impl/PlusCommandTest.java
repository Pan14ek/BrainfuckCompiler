package ua.nure.makieiev.brainfuck.command.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.nure.makieiev.brainfuck.command.Command;
import ua.nure.makieiev.brainfuck.model.Memory;

public class PlusCommandTest {

    private Command plusCommand;
    private Memory memory;

    @Before
    public void setUp() {
        plusCommand = new PlusCommand();
        memory = new Memory();
    }

    @Test
    public void shouldReturnOneAfterExecute() {
        int expected = 1;

        plusCommand.execute(memory);

        int actual = memory.getMemory()[0];

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnFiveAfterFewExecute() {
        int expected = 5;

        plusCommand.execute(memory);
        plusCommand.execute(memory);
        plusCommand.execute(memory);
        plusCommand.execute(memory);
        plusCommand.execute(memory);

        int actual = memory.getMemory()[0];

        Assert.assertEquals(expected, actual);
    }

}