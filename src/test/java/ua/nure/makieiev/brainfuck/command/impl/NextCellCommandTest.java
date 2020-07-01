package ua.nure.makieiev.brainfuck.command.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.nure.makieiev.brainfuck.command.Command;
import ua.nure.makieiev.brainfuck.model.Memory;

public class NextCellCommandTest {

    private Command nextCellCommand;
    private Command plusCommand;
    private Memory memory;

    @Before
    public void setUp() {
        nextCellCommand = new NextCellCommand();
        plusCommand = new PlusCommand();
        memory = new Memory();
    }

    @Test
    public void shouldReturnTwoInNextCell() {
        int expected = 2;

        nextCellCommand.execute(memory);
        plusCommand.execute(memory);
        plusCommand.execute(memory);

        int actual = memory.getMemory()[1];

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnOneInNextCell() {
        int expected = 1;

        plusCommand.execute(memory);
        nextCellCommand.execute(memory);
        plusCommand.execute(memory);

        int actual = memory.getMemory()[1];

        Assert.assertEquals(expected, actual);
    }

}