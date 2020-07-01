package ua.nure.makieiev.brainfuck.application;

import org.junit.Before;
import org.junit.Test;
import ua.nure.makieiev.brainfuck.exception.NotFoundCommandException;

public class BrainFuckInterpreterRunnerTest {

    private BrainFuckRunner brainFuckRunner;

    @Before
    public void setUp() {
        brainFuckRunner = new BrainFuckRunner();
    }

    @Test
    public void shouldPrintHelloWorldFirstCase() {

        brainFuckRunner.run("++++++++++[>+++++++>++++++++++>+++>+<<<<-]>++.>+.+++++" +
                "++..+++.>++.<<+++++++++++++++.>.+++.------.--------.>+.>.");

    }

    @Test
    public void shouldPrintHelloWorldSecondCase() {

        brainFuckRunner.run("+++++++++++++++++++++++++++++++++++++++++++++" +
                "+++++++++++++++++++++++++++.+++++++++++++++++" +
                "++++++++++++.+++++++..+++.-------------------" +
                "---------------------------------------------" +
                "---------------.+++++++++++++++++++++++++++++" +
                "++++++++++++++++++++++++++.++++++++++++++++++" +
                "++++++.+++.------.--------.------------------" +
                "---------------------------------------------" +
                "----.-----------------------.");

    }

    @Test
    public void shouldPrintHelloWorldThirdCase() {

        brainFuckRunner.run("++++[>++++<-]>[>+>++>[+++++++>]+++[<]>-]>>>>" +
                ">>>>-.<<<<.<..+++.<.>>>>.<<<.+++.------.>-.<<+.<------.");

    }

    @Test
    public void shouldPrintHelloWorldFourthCase() {

        brainFuckRunner.run("++++++++[>++++[>++>+++>+++>+<<<<-]>+>+>->>+[<]<-]>>." +
                ">---.+++++++..+++.>>.<-.<.+++.------.--------.>>+.>++.");

    }

    @Test(expected = NotFoundCommandException.class)
    public void shouldThrowExceptionWhenWriteWrongSymbol() {

        brainFuckRunner.run("++++++++[>++++[>++>+++>+++>+<<<<-]>+>+>->>+[<]<-]>>." +
                ">---.+++++++..+++,>>@.+++.------.--=-----.>>+.>++.");

    }

    @Test
    public void shouldWriteHelloMyNameIsOleksii() {

        brainFuckRunner.run("++++++++++[>+>+++>+++++++>++++++++++" +
                "<<<<-]>>>++.>+.+++++++..+++." +
                "<<++++++++++++++.------------.>>-" +
                "-.++++++++++++.<<.>>-----------.------------" +
                "-.++++++++++++.--------." +
                "<<.>>++++.++++++++++.<<.>+++++++.>-------.--" +
                "-----.++++++.++++++++.----------..");

    }

}