package ua.nure.makieiev.brainfuck.model;

import java.util.Arrays;
import java.util.Objects;

import static ua.nure.makieiev.brainfuck.util.constant.BrainFuckConstant.MAX_LENGTH;
import static ua.nure.makieiev.brainfuck.util.constant.BrainFuckConstant.START_POSITION;

public class Memory {

    private final byte[] memory = new byte[MAX_LENGTH];
    private int position = START_POSITION;

    public byte[] getMemory() {
        return memory;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Memory memory1 = (Memory) o;
        return position == memory1.position &&
                Arrays.equals(memory, memory1.memory);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(position);
        result = 31 * result + Arrays.hashCode(memory);
        return result;
    }

    @Override
    public String toString() {
        return "Memory{" +
                "memory=" + Arrays.toString(memory) +
                '}';
    }

}