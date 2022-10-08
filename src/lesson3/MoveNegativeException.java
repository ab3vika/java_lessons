package lesson3;

public class MoveNegativeException extends Exception {

    public MoveNegativeException() {
        super("Coordinates x or y cannot be negative");
    }
}