package ua.nure.makieiev.brainfuck.command.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.nure.makieiev.brainfuck.command.Command;
import ua.nure.makieiev.brainfuck.model.Memory;

public class MinusCommandTest {

    private Command plusCommand;
    private Command minusCommand;
    private Memory memory;

    @Before
    public void setUp() {
        plusCommand = new PlusCommand();
        minusCommand = new MinusCommand();
        memory = new Memory();
    }

    @Test
    public void shouldReturnTwoAfterPlusAndMinusExecute() {
        int expected = 2;

        plusCommand.execute(memory);
        plusCommand.execute(memory);
        plusCommand.execute(memory);
        minusCommand.execute(memory);

        int actual = memory.getMemory()[0];

        Assert.assertEquals(expected, actual);
    }


}