package ua.nure.makieiev.brainfuck.command.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.nure.makieiev.brainfuck.command.Command;
import ua.nure.makieiev.brainfuck.model.Memory;

public class PreviousCellCommandTest {

    private Command nextCellCommand;
    private Command plusCommand;
    private Command previousCellCommand;
    private Memory memory;

    @Before
    public void setUp() {
        plusCommand = new PlusCommand();
        nextCellCommand = new NextCellCommand();
        previousCellCommand = new PreviousCellCommand();
        memory = new Memory();
    }

    @Test
    public void shouldReturnTwoInFirstCell() {
        int expected = 2;

        plusCommand.execute(memory);
        nextCellCommand.execute(memory);
        plusCommand.execute(memory);
        previousCellCommand.execute(memory);
        plusCommand.execute(memory);

        int actual = memory.getMemory()[0];

        Assert.assertEquals(expected, actual);
    }

}