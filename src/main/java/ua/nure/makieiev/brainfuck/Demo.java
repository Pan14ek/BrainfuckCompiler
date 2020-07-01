package ua.nure.makieiev.brainfuck;

import ua.nure.makieiev.brainfuck.application.BrainFuckRunner;

public class Demo {

    public static void main(String[] args) {
        BrainFuckRunner brainFuckRunner = new BrainFuckRunner();
        brainFuckRunner.run("++++++++++[>+++++++>++++++++++>+++>+<<<<-]>++.>+.+++++++..+++.>++.<<+++++++++++++++.>.+++.------.--------.>+.>.");
    }

}
