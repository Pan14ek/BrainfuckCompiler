package ua.nure.makieiev.brainfuck.exception;

public class NotFoundCommandException extends RuntimeException {

    public NotFoundCommandException(String message) {
        super(message);
    }

}